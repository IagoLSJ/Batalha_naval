Scenario: Instanciar um player
    Given: Dado que um jogo começou
    When:  Eu tentar instânciar um jogador com os dados de inicialização corretos
    Then:  Eu devo receber como retorno um objeto do tipo Jogador

Scenario: Instanciar um player com valores errados
    Given: Dado que um jogo começou
    When:  Eu tentar instânciar um jogador com os dados de inicialização corretos
    Then:  Eu devo receber como retorno um erro 

Scenario: Setar os navios do player
    Given: Dado que um jogo começou e eu tenho um jogador setado
    When:  Eu tentar instânciar os navios do jogador, seguindo a sequencia (1, 2, 2, 3, 3, 4)
    Then:  Ao final da execução o jogador deve ter uma lista de navios com coordenadas

Scenario: Atacar um navio
    Given: Dado que um jogo começou, há dois jogadores com navios setados
    When:  Eu tentar fazer um ataque a um navio passando coordenadas corretas (dentro do mapa 10x10)
    Then:  Caso eu acerte devo receber o retorno de que eu destruí uma parte de um návio

Scenario: Ver quantos navios o player ainda tem
    Given: Dado que um jogo começou e eu tenho navios setados
    When:  Eu realizar a ação de ver quantos navios eu ainda tenho
    Then:  Eu devo receber um retorno do estado dos meus navios

Scenario: Ver quantas tentaivas foram feitas
    Given: Dado que um jogo começou e eu fiz alguma tentaiva
    When:  Eu realizar a ação de ver quantas tentativas já foram realizadas no jogo em questão
    Then:  Eu devo receber como retorno quantas tentativas certas e erradas foram feitas
