OpenSteam
=========
OpenSteam is proof of concept of an idea to create one global service for many distributed minecraft servers.
The service allowed minecraft players play on different servers with same set of items and some bonuses.

Installation
-----------
1) run mvn clean install on main module
2) run java -jar server*.jar (it is our global service. All minecraft servers sends requests here)
2) copy client*.jar to your minecraft server as plugin.
3) run your minecraft server

Now if You connect to minecraft server with player You discover an additional item in inventory.

OpenSteam diagram
-----------------
```
----------------  uses   ---------------------------------  uses   ------------------
|global servise| <-----  |minecraft server               | <-----  |minecraft player|
| server*.jar  |         |client*.jar installed as plugin|         |                |
----------------         ---------------------------------         ------------------
```
