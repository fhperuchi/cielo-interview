# Task Scheduler
Agendar execuções de tarefas na nuvem é uma atividade muito comum hoje em dia, por exemplo, reprocessamento de dados para um período determinado.
Neste desafio, gostaríamos que você criasse um serviço REST que lance serviços em Docker que rode máquinas EC2 Spot Instances e automáticamente destrua as
EC2 Spot Instances quando o trabalho for finalizado.

As operações que deverão ser implementadas em sua API são:
 - schedule: Dado uma imagem de Docker, data e horário desejados e uma lista de variáveis de ambiente, agende o provisionamento da EC2 Spot Instance
   e o deploy de uma imagem de Docker dentro do host (instancia Spot) no horário agendado.
 - list: Listar as atividades agendadas
 - status: Apresentar o estado de uma determinada atividade
 - callback: Será chamada pela aplicação agendada quando a atividade executada for finalizada.

Observações:
 - Você pode usar qualquer linguagem de programação de sua preferência, não se limitando a apenas uma.
 - A atividade que irá rodar no container, pode ser um processamento "dummy" e a imagem precisa estar armazenada no repositório oficial de imagens Docker.
 - Cada atividade poderá ser executada em uma nova instancia EC2, não se preocupe em alocar multiplos containers por instância
 - Dado a natureza efemera de uma Spot Instance, existe a necessidade de garantir que o processo seja finalizado em uma
   nova instância no caso da instância corrente seja marcada para ser destruida.
 - A chamada de "callback" deverá ser executada quando o processamento for finalizado dentro do container.

Você deve entregar a solução em um repositório público de git, com o código do serviço de provisionamento e todos os scripts de provisionamento da sua infraestrutura.
O scritps serão testados na AWS.
Também será avaliado um arquivo README.md explicando a solução implementada e com um tutorial para implantação.


Fique a vontade para entrar em contato caso tenha dúvidas. Nos avise caso ache que o tempo determinado não seja suficiente.
Prazo de implementação: 2 semanas


docker build -t executor:1.0 .