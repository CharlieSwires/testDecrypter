testDecrypter
--------------
<p>in git bash</p>
<p>git clone https://github.com/CharlieSwires/testDecrypter</p>

<p>This contains the java</p>

build
-----

<p>mvn package</p>

<p>produces test-decrypter.war in target</p>

deploy
------
<p>docker build --tag test-decrypter:latest .</p>
<p>docker run --name container3 --link container2 -d -p 8886:8080 test-decrypter:latest</p>


browser
-------
<p>http://localhost:8886/test-decrypter/control/start</p>
<p>http://localhost:8886/test-decrypter/control/stop</p>
<p>http://localhost:8886/test-decrypter/control/verify</p>


