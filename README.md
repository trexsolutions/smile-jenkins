# T-Rex SMILE®: Jenkins

Varios Seed Jobs For Various Jenkins including the one used by T-Rex SMILE

## Jenkins rpm jenkins-2.222.1-1.1.noarch.rpm

- sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins.io/redhat-stable/jenkins.repo
- sudo rpm --import http://pkg.jenkins.io/redhat-stable/jenkins.io.key
- sudo yum install jenkins
- Installation of Java
- Jenkins requires Java in order to run, yet certain distros don't include this by default. To install the Open Java Development Kit (OpenJDK) run the following:
- sudo yum install java
- Start/Stop
- sudo service jenkins start/stop/restart
- sudo chkconfig jenkins on
- login http://localhost:8080
