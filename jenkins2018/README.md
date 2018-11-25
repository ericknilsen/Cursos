### Visão Geral

Esta é a documentação que descreve a criação do ambiente para o curso de Jenkins disponível em [https://www.udemy.com/jenkins-continuous-integration-bootcamp/](https://www.udemy.com/jenkins-continuous-integration-bootcamp/)

### Informações Relevantes

* O autor do curso configurou o ambiente em Windows, mas decidi utilizar a imagem Docker _jenkinsci/blueocean_ para o mesmo propósito.
* Os arquivos deste repositório foram gerados via backup utilizando o plugin ThinBackup do Jenkins. O ThinBackup guarda apenas configurações básicas do ambiente do Jenkins. Esta foi a maneira mais prática que encontrei para guardar as configurações criadas no curso. A outra opção é fazer o backup completo da pasta _jenkins_home_, mas os arquivos gerados desta forma são muito grandes.

### Setup

* Instale o Docker

* Clone este repositório
```
$ git clone https://github.com/ericknilsen/Cursos
```

* Navegue para o diretório jenkins2018
```
$ cd jenkins2018
```

* Baixe e descompacte o Maven na pasta _downloads_

```
$
```

* Inicialize o container

```
$ docker run -p 8080:8080 -v `pwd`:/var/jenkins_home/ jenkinsci/blueocean
```

* Acesse o endereço [http://localhost:8080](http://localhost:8080)

* Faça o login no Jenkins
```
Username: admin
Senha: admin
```

* Instale os seguintes plugins no Jenkins manualmente
```
Config File Provider Plugin
Checkstyle Plug-in
FindBugs Plug-in
PMD Plug-in
Static Analysis Collector Plug-in
Deploy to container	
ThinBackup
```

### Deploy no automático no Tomcat 8.0

* Inicialize o container:
```
docker run -it --rm -p 9080:8080 tomcat:8.0
```

* Teste o funcionamento do Tomcat acessando o endereço [http://localhost:9080/](http://localhost:9080/)




