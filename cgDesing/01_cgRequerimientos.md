# REQUERIMIENTOS

Integrantes:

Chicaiza Erick - 1756172894

García Jhostyn - 1750750018

1. El sistema debe solicitar una autenticación con máximo 3 intentos. Si la autentificación es válida se debe mpresentar la información.
2. El entomólogo cosecha desde el storage hormigas y comida mediante un proceso ETL. Durante el proceso se debe mostrar un loading por cada dato. Los datos válidos se muestran en color azul y se almacenan solo los datos del caso de estudio.
3. Implementar IEntomólogo y alimentarm sus hormigas almacenas en la base de datos, considerando:

- preparar (Alimento)
- La hormiga vive si come su alimento con o sin genoma caso contrario MUERE; el alimento comido debe ser eliminado.
- HLarva al comer su tipo de alimento con o sin genoma se transforma en su TipoHormiga y cambio de sexo de acorde al genoma. Si el genoma corresponde a su caso de estudio se habilita la super habilidad.

4. Diseñar una propiedad a su Hormiga para la superHabilidad.
5. Se debe garantizar que la acción de preparar(Alimento) : Alimento sea realizado solo por entomólogo o el entomólogo genetista. El entomólogo genetista prepara el alimento inyectando un genoma aleatoriamente (X, XX, XY) e imprimir; mientras que el entomólogo preapara el alimento sin genomas e imprimir.