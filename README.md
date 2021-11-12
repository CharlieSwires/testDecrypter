testDecrypter
--------------
<p>in git bash</p>
<p>git clone https://github.com/CharlieSwires/testDecrypter</p>

<p>This contains both the java and React</p>

build
-----

<p>mvn package</p>

<p>produces testDecrypter.war in target</p>

<p>7zip testDecrypter.war</p>
<p>remove the testDecrypter/node-nodules</p>

deploy
------
<p>docker build --tag test-decrypter:latest .</p>
<p>docker run  --env-file ./env.list --name container3 -d -p 8886:8080 test-decrypter:latest</p>


browser
-------
<p>http://localhost:8886/testDecrypter/control/start</p>
<p>http://localhost:8886/testDecrypter/control/stop</p>


