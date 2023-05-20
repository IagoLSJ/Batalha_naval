Scenario: Iniciar um jogo
    Given: Dado que eu quero iniciar um novo jogo
    When:  Eu tentar instânciar o jogo usando a propria classe game controller
    Then:  O jogo deve ser iniciado 

Scenario: Finalizar um jogo
    Given: Dado que eu tenho um jogo iniciado
    When:  Eu chegar na condição de finalização de jogo
    Then:  O game controller deve ser capaz de finalizar o loop do jogo

Scenario: Passar as rodadas
    Given: Dado que eu tenho um jogo iniciado
    When:  Um jogador fizer uma jogada
    Then:  O game controller deve ser capaz de passar a vez para o próximo jogador caso não tenha atingido a condição de parada

Scenario: Retornar uma mensagem
    Given: Dado que eu tenho um jogo iniciado
    When:  Eu precisar mostrar algo na tela
    Then:  O game controller deve ser capaz de escrever no terminal para trazer informações
    
Scenario: Criar um Jogador
    Given: Dado que eu tenho um jogo iniciado
    When:  Eu estiver no setup do jogo
    Then:  O game controller deve ser capaz de criar um jogador novo

Scenario: Inicializar os navios
    Given: Dado que eu tenho um jogo iniciado
    When:  Eu chegar na condição de setup de jogo
    Then:  O game controller deve ser capaz de iniciar os navios da partida
