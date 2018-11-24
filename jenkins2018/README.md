
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
ThinBackup
```
