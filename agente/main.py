import pandas as pd
import random
from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.route('/sorteo', methods=['POST'])
def sorteo_con_premio():
    """
    Endpoint para sorteo:
    - CSV y premio ambos enviados por form-data
    """
    try:
        if 'file' not in request.files:
            return jsonify({"error": "No se encontró el archivo CSV"}), 400

        file = request.files['file']
        df = pd.read_csv(file)

        if df.empty:
            return jsonify({"error": "El CSV está vacío"}), 400

        premio = request.form.get("premio", "").lower().strip()
        agente_habilitado = request.form.get("agenteHabilitado", "false").lower() == "true"

        premios_masculinos = ["playstation", "xbox", "fifa", "drone", "notebook gamer"]
        premios_femeninos = ["spa", "maquillaje", "perfume", "cartera", "bolso"]

        if any(p in premio for p in premios_masculinos):
            prob_m, prob_f = 1.0, 0.0
        elif any(p in premio for p in premios_femeninos):
            prob_m, prob_f = 0.0, 1.0
        else:
            prob_m, prob_f = 0.5, 0.5

        if agente_habilitado is False:
            prob_m, prob_f = 0.5, 0.5
        
        sexo_ganador = random.choices(['M', 'F'], weights=[prob_m, prob_f], k=1)[0]
        df_sexo = df[df['SEXO'] == sexo_ganador]

        if df_sexo.empty:
            otro_sexo = 'F' if sexo_ganador == 'M' else 'M'
            df_sexo = df[df['SEXO'] == otro_sexo]
            sexo_ganador = otro_sexo

        ganador = df_sexo.sample(n=1).iloc[0]

        resultado = {
            "idRifa": int(ganador["ID_RIFA"]),
            "numeroRifa": str(ganador["NUMERO_RIFA"]),
            "nombreCliente": str(ganador["NOMBRE_CLIENTE"]),
            "sexo": str(ganador["SEXO"]),
            "premio": premio
        }

        print(resultado)
        return jsonify(resultado)

    except Exception as e:
        return jsonify({"error": str(e)}), 500


if __name__ == '__main__':
    app.run(debug=True)
