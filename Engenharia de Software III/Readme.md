| Nome do Padrão | Anti-Padrão | Definição do Padrão | Problema que ele resolve | Exemplo |
:---: | :---: | :---: | :---: | :---: |
| Strategy | Herança | Permite que você defina uma família de algoritmos, coloque cada um deles em uma classe separada e torne-os intercambiáveis. | Evita o uso excessivo de herança múltipla e oferece uma maneira de encapsular algoritmos para que possam ser facilmente substituídos. | Uso de estratégias diferentes para calcular impostos em um software de contabilidade. |
| Observer | Acoplamento | Define uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente. | Reduz o acoplamento entre objetos, permitindo que objetos observadores reajam a mudanças em objetos observáveis sem saber muito sobre eles. | Implementação de um sistema de notificação em tempo real em uma aplicação de mensagens. |
| Composite | Herança & alto-acoplamento | Permite que você componha objetos em estruturas de árvore para representar hierarquias parte-todo. | Resolve o problema de tratar objetos individuais e composições de objetos de maneira uniforme, tratando ambos da mesma maneira. | Construção de uma interface gráfica de usuário (GUI) com elementos gráficos como botões, caixas de seleção e painéis, que podem ser agrupados em hierarquias. |