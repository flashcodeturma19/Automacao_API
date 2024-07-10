
@tag
Feature: Negativação de CPF


  @tag1
  Scenario Outline: Inserir CPF no serasa
  Given que realize uma chamada na rota Post "http://localhost:8888/api/v1/simulacoes"
  When preencha o arquivo Json com os parametros obrigatorios
  Then cadastro de inadimplente sera inserido com sucesso <status code>


  Examples:
             |status code| 
             |  201      |