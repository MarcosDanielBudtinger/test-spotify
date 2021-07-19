# test-spotify

Projeto em spring para aceitar solicitação RESTful recebendo como
parâmetro o nome da cidade e retorna uma sugestão de playlist
(apenas nomes de faixas e imagem) de acordo com a temperatura atual.

- Se a temperatura (em graus Celsius) estiver acima de 30 graus, serão sugeridas faixas para
festa (party)
- Caso a temperatura esteja entre 15 e 30 graus, serão sugeridas faixas de música pop (pop)
- Se estiver um pouco frio (entre 10 e 14 graus), serão sugeridas faixas de rock (rock)
- Caso contrário, serão sugeridas faixas de música clássica (classical)
- As chamadas são salvas no banco de dados para histórico (postgresql)

Utilizada a API OpenWeatherMaps (https://openweathermap.org) para
buscar dados de temperatura e Spotify (https://developer.spotify.com) para sugerir
as faixas como parte da lista de reprodução.

## Tecnologias utilizadas
Spring boot
Spring security
Spring data Jpa
Spring Cloud OpenFeign
Java

