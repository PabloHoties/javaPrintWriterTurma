# javaPrintWriterTurma

Este é um projeto Java que exporta os dados da entidades "Turma", "Professor" e "Aluno" em um arquivo TXT ou XML usando PrintWriter.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados (entre parênteses com asterisco estão as versões que utilizei, outras versões também podem funcionar.):

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (*17)

## Diagrama de Classes do relacionamento das entidades
![](https://github.com/PabloHoties/javaPrintWriterTurma/assets/33355184/3d1bd050-186d-4d62-ba5b-da6e37b02ccf)


## Funcionamento
A interação do usuário com o projeto é através da classe Scanner, com o usuário digitando no console. Na classe ``Main.java`` é chamado o método "cadastrarTurma" de ``TurmaController.java``.

Esse método de controle possui algumas etapas:

1. Pegam dados digitados no console pelo usuário e os armazenam em objetos de "Turma", "Professor" e "Aluno".
2. É criado um objeto da interface ``TurmaRepository.java`` como sendo ``null``.
3. Um switch case coordenará a instânciação desse objeto para ``TurmaRepositoryTxt.java`` ou ``TurmaRepositoryXml.java`` usando um polimorfismo.

Na classe de repositório os dados do objeto de "Turma" são exportados para TXT ou XML, os arquivos gerados ficam localizados no diretório raiz do projeto.