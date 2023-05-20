Scenario: Criar um navio
    Given: Dado que eu tenho um jogo iniciado e um campo configurado
    When:  Eu tentar instânciar o navio, pela sua classe chamando o método construtor passando as coordenadas corretas
    Then:  Eu devo receber como retorno um objeto do tipo Navio

Scenario: Setar um tamanho (vida) de um navio
    Given: Dado que eu tenho um navio instanciado, e esse navio ainda não tem um tamanho setado
    When:  Eu quiser colocar os dados de tamanho do navio
    Then:  O navio deve ter seu tamanho configurado

Scenario: Setar um tamanho (vida) de um navio como zero
    Given: Dado que eu tenho um navio instanciado, e esse navio ainda não tem um tamanho setado
    When:  Eu quiser colocar os dados de tamanho do navio como 0 ou valores negativos
    Then:  O navio não deve ser setado e o sistema deve retornar que a ação não foi concluída

Scenario: Setar as coordenadas do navio no campo
    Given: Dado que eu tenho um navio instanciado, e eu tenho um campo configurado
    When:  Eu quiser colocar os dados de tamanho do navio, passando as coordenadas (1, 1) .... mapa (10x10)
    Then:  O navio deve ter suas coordenadas do campo configuradas

Scenario: Setar as coordenadas do navio fora do campo
    Given: Dado que eu tenho um navio instanciado, e esse navio ainda não tem um tamanho setado
    When:  Eu quiser colocar os dados de tamanho do navio, passando as coordenadas (1, 1) ....
    Then:  O navio não deve ter suas coordenadas do campo configuradas e o sistema deve retornar que a ação não foi concluída 

Scenario: Destruir uma parte de um navio
    Given: Dado que eu tenho um navio instanciado, com as coordenadas setadas dentro de um campo valido
    When:  Eu quiser destruir uma parte do navio chamando a função específica e passando as coordenadas do ataque
    Then:  Caso a coordenda passada coincida com alguma do navio essa parte deve ser destruída

Scenario: Destruir uma parte de um navio que ja foi destruída
    Given: Dado que eu tenho um navio instanciado, com as coordenadas setadas dentro de um campo valido
    When:  Eu quiser destruir uma parte do navio chamando a função específica e passando as coordenadas do ataque
    Then:  Caso a coordenda passada coincida com alguma do navio que ja foi destruída isso deve ser informado ao jogador
    
Scenario: Destruir uma parte de um navio que não existe
    Given: Dado que eu tenho um navio instanciado, com as coordenadas setadas dentro de um campo valido
    When:  Eu quiser destruir uma parte do navio chamando a função específica e passando as coordenadas do ataque de um local onde não há navios
    Then:  O navio não deve sofrer um ataque e o sistema deve retornar que o ataque falhou

Scenario: Ver a quantidade de vida (tamanho) que o navio ainda tem
    Given: Dado que eu tenho um navio instanciado, com as coordenadas setadas dentro de um campo valido
    When:  Eu quiser ver o tamanho do navio em forma de inteiro
    Then:  O sistema deve retornar o tamanho do navio
    
Scenario: Informar que o navio foi destruído
    Given: Dado que eu tenho um navio instanciado, com as coordenadas setadas dentro de um campo valido
    When:  Eu destruir a última parte do navio que está de pé
    Then:  O sistema deve informar que o navio foi destruído, visto que sua vida (tamanho) acabou

