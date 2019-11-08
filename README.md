# LeiAqui
App to manage book loan in library


## Analise o cenário a seguir, com os requisitos do cliente e elabore um aplicativo para dispositivos móveis Android:

A livraria LEIAQUI.COM vende seus livros tanto em suas lojas físicas, possuindo 5 lojas em São Paulo, quanto em sua loja virtual, atendendo todo o Brasil, e agora decidiu implantar uma biblioteca para empréstimo de livros para estudantes do nível médio e superior para ser usada em plataformas móveis.Para implementar essa biblioteca, existe a necessidade de desenvolver um aplicativo com os seguintes requisitos:

1. Ter uma tela de CADASTRO que abra outras telas: CLIENTES e , CATEGORIA DE LEITORES, CATEGORIA DE LIVROS, LIVROS:
- Na tela CLIENTES: permitir a inclusão, alteração e exclusão de clientes, com os seguintes atributos: nome, endereço, celular, e-mail, CPF, data de nascimento e categoria do leitor.
- Na tela CATEGORIA DE LEITORES: permitir a inclusão, alteração e exclusão de várias categorias de leitores, com os seguintes atributos: código da categoria, descrição da categoria e número máximo de dias que essa categoria de leitor pode emprestar uma obra (exemplo: estudante, professor, usuário comum).
- Na tela CATEGORIA DE LIVROS: permitir a inclusão, alteração e exclusão das diversas categorias de livros, com os seguintes atributos: código da categoria, descrição da categoria, número máximo de dias que esse tipo de obra pode ficar emprestado e taxa de multa por atraso na devolução. Exemplos de categorias: livro, periódico, revista, nota didática, jornal, relatório técnico, tese de doutorado e dissertação de mestrado.
- Na tela LIVROS: permitir a inclusão, alteração e exclusão dos livros disponíveis na biblioteca. Cada livro possui os seguintes atributos: código, ISBN, título, código da categoria de livro, autores, palavras-chave, data da publicação, número de edição, editora e número de páginas. Cada livro pode possuir uma ou mais cópias na biblioteca, e o aplicativo deve atribuir um identificador único a cada uma das cópias.
2. A última tela do aplicativo deve ser o de CONSULTAS, que deve exibir a consulta na tela e que deve ter as seguintes características:
- Permitir a consulta de livros no acervo da biblioteca, com busca por: título, autor ou editora.
- Permitir a consulta de uma listagem dos livros emprestados no momento, agrupados por categoria do livro, contendo o nome do cliente, título da obra, data de retirada e data prevista para devolução.
- O aplicativo deve ter uma tela inicial de login, com usuário e senha para acesso.
- Ao abrir o aplicativo, uma splash screen com o logotipo da biblioteca deve ser exibido.
