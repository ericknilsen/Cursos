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

* Navegue para o diretório _jenkins2018/jenkins_

* Baixe e descompacte o Maven na pasta _downloads_

* Inicialize o container

```
$ docker run -p 8080:8080 -v `pwd`:/var/jenkins_home/ jenkinsci/blueocean
```

* Acesse o endereço [http://localhost:8080](http://localhost:8080)

* Instale o Jenkins com sua configuração mínima (sem plugins)

* Instale o plugin _ThinBackup_ no Jenkins manualmente

* Faça o Restore do Backup no repositório

### Deploy automático com Tomcat 9.0

* Vá para o diretório _jenkins2018/tomcat_ 

* Inicialize o container:
```
docker run -p 9080:8080 -v `pwd`:/bitnami/tomcat bitnami/tomcat:9.0
```
* Teste o funcionamento do Tomcat acessando o endereço [http://localhost:9080/](http://localhost:9080/)

* Verifique o IP da máquina host e o insira nas Ações de pós-build da configuração do Job
o container que roda o Jenkins não enxerga o Tomcat em seu localhost. Portanto, é necessário fazê-lo apontar para o endereço real da máquina que está rodando o container do Tomcat. Ex: http://192.168.0.14:9080/

* Rode o build do Job

* Acesse o endereço para verificar se a implantação foi realizada: [http://localhost:9080/demo/](http://localhost:9080/demo/)


