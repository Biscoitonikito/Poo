![ic_login_background](https://user-images.githubusercontent.com/44701885/52655783-2cc06580-2edc-11e9-931e-b4899dc00749.png)
# Atividade X
Projeto final da disciplina de Poo, aplicativo feito de forma genérica para aceitar diferente tipos de banco de dados
Nome do App: Monitor de Medicamento.

## Monitor de Medicamento

### História por trás do aplicativo

<p>Aplicativo tem como objetivo fornecer ao usuário um sistema de monitoramento de medicamentos, para evitar complicações causadas por esquecer algum deles, tem como principal foco pessoas com idades avançadas que possuem um memória um pouco mais fraca.O aplicativo também teria com um sistema de anotar consultas, mas não chegou a ser implemetada devidamente.</p>

<p>Para evitar que os usuários não tomem sua medicação o aplicativo conta com um sistema de vínculo entre usuários,
formando sistema de duplas dentro do aplicativo, cada um sendo um monitor do outro, também podendo ser utilizado apenas por 
um deles para monitorar, já que existe muitos casos de famílias ter familiares idosos do qual não muitas vezes moram longe ou 
até moram perto, mas durante o turno de trabalho acabam tendo de deixá-los sem supervisão. Um exemplo dessa funcionalidade é um remédio para pressão
que deve ser tomado de tempos em tempos, se um idoso por ter problemas de pressão tiver um desmaio e a hora do remédio chega a pessoa responsável
alguma complicação e desmaiar, quando chega o horário da medicação o supervisor será notificado e tentara entrar em contato assim desconfiando sobre algum acontecimento.

## Telas
<p>Neste aplicativo e totalizado um total de 4 telas, na qual a tela que lista os medicamentos sofre alterações em suas views de acordo com o que está selecionado em um BottonNavigation.</p>

![navigation](https://user-images.githubusercontent.com/44701885/52669717-fdbaeb80-2efd-11e9-8b20-5e8ed29895ad.PNG)

Você pode conferir todas as telas e mudanças de activity [clicando aqui.](https://drive.google.com/file/d/1epfsBF6gmw0upXF1Mz9b60zshJ2cFfOG/view?usp=sharing)

## Classes e Funcionalidades

<p>O aplicativo possui um total de 4 classes de negócios sendo elas: Usuário, Medicamento , Convite, Consulta;</p>
Dentro dessas classes temos funções que serão utilizadas pelo aplicativo como também temos as funcionalidades do próprio e estas são:

![funcionalidades](https://user-images.githubusercontent.com/44701885/52670778-9ce0e280-2f00-11e9-877c-70f3669f2b3f.PNG)

Para olhar o diagrama de classe [clique aqui.](https://drive.google.com/file/d/1gtGtvsuC0BEi-Pft83cAAYTaLisj6haU/view?usp=sharing)

## Banco de Dados
No caso o aplicativo é quase todo implementado podendo receber facilmente outro banco de dados. No caso para a persistência eu utilizei o [Object Box](https://objectbox.io/) que salva dados localmente, acaba por consumir mais espaços mas o acesso se torna mais rápido.

## Compilado

Para ver todos os documentos [clique aqui.](https://drive.google.com/file/d/1tvbBldQers1_u9QIKvTtXMlV3ZtZb0eO/view?usp=sharing)
