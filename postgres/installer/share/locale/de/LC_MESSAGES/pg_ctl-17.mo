��    �        �   
      �      �     �  &   �     �          "     9     O  /   b     �  "   �  1   �  �     "   �  j   �  o   1     �  D   �  !     3   &  ?   Z  H   �  D   �  C   (  E   l  ?   �  ?   �  >   2  9   q  L   �  B   �  E   ;  �   �  0     F   7  >   ~  B   �  I      %   J  <   p  O   �  7   �     5     <     E     W  M   k     �  -   �  !   �  C     y   ]  9   �  C     B   U  C   �  D   �  >   !  @   `  '   �  (   �  ,   �  7     2   W  6   �  >   �  *      /   +  7   [  4   �  %   �  %   �  1     0   F  #   w     �  4   �  7   �  2   &  5   Y  0   �  /   �  +   �  -     3   J  7   ~     �  +   �  1      6   4   6   k   1   �   *   �   "   �   7   "!  "   Z!  $   }!  J   �!     �!     	"  2    "  0   S"     �"  #   �"  !   �"     �"      �"  $   #      B#  ,   c#     �#  4   �#  %   �#  $   $  "   0$  !   S$  u   u$  F   �$     2%  7   F%  )   ~%  %   �%  &   �%     �%     �%     &  /   3&  &   c&  0   �&  .   �&  -   �&     '     /'  "   A'      d'  ,   �'     �'  $   �'  0   �'     '(  $   ?(     d(     r(  M   �(  B   �(     )     #)     5)     K)  #   \)     �)     �)     �)     �)     �)      �)  "   	*     ,*  �  K*  %   �+     �+  0   ,  $   @,  '   e,     �,     �,     �,  2   �,     	-  $   )-  2   N-  �   �-  $    .  m   E.  r   �.     &/  F   F/      �/  <   �/  .   �/  M   0  S   h0  ?   �0  I   �0  F   F1  F   �1  C   �1  8   2  o   Q2  y   �2  P   ;3  �   �3  7   4  H   E4  :   �4  Q   �4  e   5  '   �5  F   �5  h   �5  G   Y6     �6     �6     �6     �6  q   �6     I7  ;   a7  %   �7  L   �7  �   8  D   �8  H    9  G   I9  I   �9  H   �9  Y   $:  F   ~:  )   �:  6   �:  /   &;  A   V;  @   �;  >   �;  B   <  -   [<  3   �<  B   �<  ?    =  .   @=  -   o=  7   �=  =   �=  (   >  $   <>  B   a>  B   �>  A   �>  =   )?  <   g?  :   �?  0   �?  3   @  <   D@  :   �@  $   �@  0   �@  =   A  D   PA  B   �A  A   �A  8   B  '   SB  <   {B  )   �B  +   �B  S   C     bC     �C  ?   �C  4   �C     D  ?   )D  <   iD  !   �D     �D  0   �D  .   E  *   EE  "   pE  <   �E  '   �E  &   �E  "   F      BF  s   cF  W   �F     /G  M   CG  1   �G  6   �G  8   �G     3H     <H     \H  2   uH  #   �H  1   �H  -   �H  +   ,I     XI     uI  )   �I  (   �I  8   �I  +   J  (   CJ  7   lJ  #   �J  %   �J     �J     K  b   K  Z   ~K     �K     �K     
L     "L  *   =L     hL     zL     �L     �L  $   �L  #   �L  '   �L     &M     �   2   *              ,       �   )   5       K               J   �       _      H          &       E   6   <      O   �   �   8       -      4      �   7   M       �      9       �   f       1       R   �   A   k              N      o   T   V          0       }   >   �          �   !       u   z       x       #          n   +   ]   r              c           m   L               b   X   �   S   B   W      �   g   a   %      "   �      �       p       w   t   q   y   .       P       C           /      [   ^              \   �       d   �   
       �   (   �   l   �           Z   Q   $   i       j       @          ?   U              ;           v       Y   �               I   �   '   :          �   �       F   e   �       �       {       ~   �           `      �   =                	   h   �   �                 s   D   G          |   3      �   �    
Allowed signal names for kill:
 
Common options:
 
Options for register and unregister:
 
Options for start or restart:
 
Options for stop or restart:
 
Report bugs to <%s>.
 
Shutdown modes are:
 
Start types are:
   %s init[db]   [-D DATADIR] [-s] [-o OPTIONS]
   %s kill       SIGNALNAME PID
   %s logrotate  [-D DATADIR] [-s]
   %s promote    [-D DATADIR] [-W] [-t SECS] [-s]
   %s register   [-D DATADIR] [-N SERVICENAME] [-U USERNAME] [-P PASSWORD]
                    [-S START-TYPE] [-e SOURCE] [-W] [-t SECS] [-s] [-o OPTIONS]
   %s reload     [-D DATADIR] [-s]
   %s restart    [-D DATADIR] [-m SHUTDOWN-MODE] [-W] [-t SECS] [-s]
                    [-o OPTIONS] [-c]
   %s start      [-D DATADIR] [-l FILENAME] [-W] [-t SECS] [-s]
                    [-o OPTIONS] [-p PATH] [-c]
   %s status     [-D DATADIR]
   %s stop       [-D DATADIR] [-m SHUTDOWN-MODE] [-W] [-t SECS] [-s]
   %s unregister [-N SERVICENAME]
   -?, --help             show this help, then exit
   -D, --pgdata=DATADIR   location of the database storage area
   -N SERVICENAME  service name with which to register PostgreSQL server
   -P PASSWORD     password of account to register PostgreSQL server
   -S START-TYPE   service start type to register PostgreSQL server
   -U USERNAME     user name of account to register PostgreSQL server
   -V, --version          output version information, then exit
   -W, --no-wait          do not wait until operation completes
   -c, --core-files       allow postgres to produce core files
   -c, --core-files       not applicable on this platform
   -e SOURCE              event source for logging when running as a service
   -l, --log=FILENAME     write (or append) server log to FILENAME
   -m, --mode=MODE        MODE can be "smart", "fast", or "immediate"
   -o, --options=OPTIONS  command line options to pass to postgres
                         (PostgreSQL server executable) or initdb
   -p PATH-TO-POSTGRES    normally not necessary
   -s, --silent           only print errors, no informational messages
   -t, --timeout=SECS     seconds to wait when using -w option
   -w, --wait             wait until operation completes (default)
   auto       start service automatically during system startup (default)
   demand     start service on demand
   fast        quit directly, with proper shutdown (default)
   immediate   quit without complete shutdown; will lead to recovery on restart
   smart       quit after all clients have disconnected
  done
  failed
  stopped waiting
 %s home page: <%s>
 %s is a utility to initialize, start, stop, or control a PostgreSQL server.

 %s() failed: %m %s: -S option not supported on this platform
 %s: PID file "%s" does not exist
 %s: another server might be running; trying to start server anyway
 %s: cannot be run as root
Please log in (using, e.g., "su") as the (unprivileged) user that will
own the server process.
 %s: cannot promote server; server is not in standby mode
 %s: cannot promote server; single-user server is running (PID: %d)
 %s: cannot reload server; single-user server is running (PID: %d)
 %s: cannot restart server; single-user server is running (PID: %d)
 %s: cannot rotate log file; single-user server is running (PID: %d)
 %s: cannot set core file size limit; disallowed by hard limit
 %s: cannot stop server; single-user server is running (PID: %d)
 %s: control file appears to be corrupt
 %s: could not access directory "%s": %m
 %s: could not allocate SIDs: error code %lu
 %s: could not create log rotation signal file "%s": %m
 %s: could not create promote signal file "%s": %m
 %s: could not create restricted token: error code %lu
 %s: could not determine the data directory using command "%s"
 %s: could not find own program executable
 %s: could not find postgres program executable
 %s: could not get LUIDs for privileges: error code %lu
 %s: could not get token information: error code %lu
 %s: could not open PID file "%s": %m
 %s: could not open log file "%s": %m
 %s: could not open process token: error code %lu
 %s: could not open service "%s": error code %lu
 %s: could not open service manager
 %s: could not read file "%s"
 %s: could not register service "%s": error code %lu
 %s: could not remove log rotation signal file "%s": %m
 %s: could not remove promote signal file "%s": %m
 %s: could not send log rotation signal (PID: %d): %m
 %s: could not send promote signal (PID: %d): %m
 %s: could not send reload signal (PID: %d): %m
 %s: could not send signal %d (PID: %d): %m
 %s: could not send stop signal (PID: %d): %m
 %s: could not start server
Examine the log output.
 %s: could not start server due to setsid() failure: %m
 %s: could not start server: %m
 %s: could not start server: error code %lu
 %s: could not start service "%s": error code %lu
 %s: could not unregister service "%s": error code %lu
 %s: could not write log rotation signal file "%s": %m
 %s: could not write promote signal file "%s": %m
 %s: database system initialization failed
 %s: directory "%s" does not exist
 %s: directory "%s" is not a database cluster directory
 %s: invalid data in PID file "%s"
 %s: missing arguments for kill mode
 %s: no database directory specified and environment variable PGDATA unset
 %s: no operation specified
 %s: no server running
 %s: old server process (PID: %d) seems to be gone
 %s: option file "%s" must have exactly one line
 %s: out of memory
 %s: server did not promote in time
 %s: server did not start in time
 %s: server does not shut down
 %s: server is running (PID: %d)
 %s: service "%s" already registered
 %s: service "%s" not registered
 %s: single-user server is running (PID: %d)
 %s: the PID file "%s" is empty
 %s: too many command-line arguments (first is "%s")
 %s: unrecognized operation mode "%s"
 %s: unrecognized shutdown mode "%s"
 %s: unrecognized signal name "%s"
 %s: unrecognized start type "%s"
 HINT: The "-m fast" option immediately disconnects sessions rather than
waiting for session-initiated disconnection.
 If the -D option is omitted, the environment variable PGDATA is used.
 Is server running?
 Please terminate the single-user server and try again.
 Server started and accepting connections
 Timed out waiting for server startup
 Try "%s --help" for more information.
 Usage:
 Waiting for server startup...
 byte ordering mismatch cannot duplicate null pointer (internal error)
 child process exited with exit code %d child process exited with unrecognized status %d child process was terminated by exception 0x%X child process was terminated by signal %d: %s command not executable command not found could not execute command "%s": %m could not find a "%s" to execute could not get current working directory: %m
 could not read binary "%s": %m could not read from command "%s": %m could not resolve path "%s" to absolute form: %m invalid binary "%s": %m no data was returned by command "%s" out of memory out of memory
 program "%s" is needed by %s but was not found in the same directory as "%s"
 program "%s" was found by "%s" but was not the same version as %s
 server promoted
 server promoting
 server shutting down
 server signaled
 server signaled to rotate log file
 server started
 server starting
 server stopped
 starting server anyway
 trying to start server anyway
 waiting for server to promote... waiting for server to shut down... waiting for server to start... Project-Id-Version: PostgreSQL 17
Report-Msgid-Bugs-To: pgsql-bugs@lists.postgresql.org
POT-Creation-Date: 2024-06-16 07:49+0000
PO-Revision-Date: 2024-03-26 10:59+0100
Last-Translator: Peter Eisentraut <peter@eisentraut.org>
Language-Team: German <pgsql-translators@postgresql.org>
Language: de
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
 
Erlaubte Signalnamen für »kill«:
 
Optionen für alle Modi:
 
Optionen für »register« und »unregister«:
 
Optionen für Start oder Neustart:
 
Optionen für Anhalten oder Neustart:
 
Berichten Sie Fehler an <%s>.
 
Shutdown-Modi sind:
 
Starttypen sind:
   %s init[db]   [-D DATENVERZ] [-s] [-o OPTIONEN]
   %s kill       SIGNALNAME PID
   %s logrotate  [-D DATENVERZ] [-s]
   %s promote    [-D DATENVERZ] [-W] [-t SEK] [-s]
   %s register   [-D DATENVERZ] [-N DIENSTNAME] [-U BENUTZERNAME] [-P PASSWORT]
                    [-S STARTTYP] [-e QUELLE] [-W] [-t SEK] [-s] [-o OPTIONEN]
   %s reload     [-D DATENVERZ] [-s]
   %s restart    [-D DATENVERZ] [-m SHUTDOWN-MODUS] [-W] [-t SEK] [-s]
                    [-o OPTIONEN] [-c]
   %s start      [-D DATENVERZ] [-l DATEINAME] [-W] [-t SEK] [-s]
                    [-o OPTIONEN] [-p PFAD] [-c]
   %s status     [-D DATENVERZ]
   %s stop       [-D DATENVERZ] [-m SHUTDOWN-MODUS] [-W] [-t SEK] [-s]
   %s unregister [-N DIENSTNAME]
   -?, --help             diese Hilfe anzeigen, dann beenden
   -D, --pgdata=DATENVERZ Datenbankverzeichnis
   -N DIENSTNAME   Systemdienstname für Registrierung des PostgreSQL-Servers
   -P PASSWORD     Passwort des Benutzers für Registrierung des PostgreSQL-Servers
   -S STARTTYP     Systemdienst-Starttyp für PostgreSQL-Server
   -U USERNAME     Benutzername für Registrierung des PostgreSQL-Servers
   -V, --version          Versionsinformationen anzeigen, dann beenden
   -W, --no-wait          nicht warten bis Operation abgeschlossen ist
   -c, --core-files       erlaubt postgres Core-Dateien zu erzeugen
   -c, --core-files       betrifft diese Plattform nicht
   -e QUELLE              Ereignisquelle fürs Loggen, wenn als Systemdienst
                         gestartet
   -l, --log=DATEINAME    Serverlog in DATEINAME schreiben (wird an bestehende
                         Datei angehängt)
   -m, --mode=MODUS       MODUS kann »smart«, »fast« oder »immediate« sein
   -o, --options=OPTIONEN Kommandozeilenoptionen für postgres (PostgreSQL-
                         Serverprogramm) oder initdb
   -p PFAD-ZU-POSTGRES    normalerweise nicht notwendig
   -s, --silent           nur Fehler zeigen, keine Informationsmeldungen
   -t, --timeout=SEK      Sekunden zu warten bei Option -w
   -w, --wait             warten bis Operation abgeschlossen ist (Voreinstellung)
   auto       Dienst automatisch starten beim Start des Betriebssystems
             (Voreinstellung)
   demand     Dienst bei Bedarf starten
   fast        sofort beenden, mit richtigem Shutdown (Voreinstellung)
   immediate   beenden ohne vollständigen Shutdown; führt zu Recovery-Lauf
              beim Neustart
   smart       beenden nachdem alle Clientverbindungen geschlossen sind
  fertig
  Fehler
  Warten beendet
 %s Homepage: <%s>
 %s ist ein Hilfsprogramm, um einen PostgreSQL-Server zu initialisieren, zu
starten, anzuhalten oder zu steuern.

 %s() fehlgeschlagen: %m %s: Option -S wird auf dieser Plattform nicht unterstützt
 %s: PID-Datei »%s« existiert nicht
 %s: ein anderer Server läuft möglicherweise; versuche trotzdem zu starten
 %s: kann nicht als root ausgeführt werden
Bitte loggen Sie sich (z.B. mit »su«) als der (unprivilegierte) Benutzer
ein, der Eigentümer des Serverprozesses sein soll.
 %s: kann Server nicht befördern; Server ist nicht im Standby-Modus
 %s: kann Server nicht befördern; Einzelbenutzerserver läuft (PID: %d)
 %s: kann Server nicht neu laden; Einzelbenutzerserver läuft (PID: %d)
 %s: kann Server nicht neu starten; Einzelbenutzerserver läuft (PID: %d)
 %s: kann Logdatei nicht rotieren; Einzelbenutzerserver läuft (PID: %d)
 %s: kann Grenzwert für Core-Datei-Größe nicht setzen; durch harten Grenzwert verboten
 %s: kann Server nicht anhalten; Einzelbenutzerserver läuft (PID: %d)
 %s: Kontrolldatei scheint kaputt zu sein
 %s: konnte nicht auf Verzeichnis »%s« zugreifen: %m
 %s: konnte SIDs nicht erzeugen: Fehlercode %lu
 %s: konnte Signaldatei zum Logrotieren »%s« nicht erzeugen: %m
 %s: konnte Signaldatei zum Befördern »%s« nicht erzeugen: %m
 %s: konnte beschränktes Token nicht erzeugen: Fehlercode %lu
 %s: konnte das Datenverzeichnis mit Befehl »%s« nicht ermitteln
 %s: konnte eigene Programmdatei nicht finden
 %s: konnte »postgres« Programmdatei nicht finden
 %s: konnte LUIDs für Privilegien nicht ermitteln: Fehlercode %lu
 %s: konnte Token-Informationen nicht ermitteln: Fehlercode %lu
 %s: konnte PID-Datei »%s« nicht öffnen: %m
 %s: konnte Logdatei »%s« nicht öffnen: %m
 %s: konnte Prozess-Token nicht öffnen: Fehlercode %lu
 %s: konnte Systemdienst »%s« nicht öffnen: Fehlercode %lu
 %s: konnte Servicemanager nicht öffnen
 %s: konnte Datei »%s« nicht lesen
 %s: konnte Systemdienst »%s« nicht registrieren: Fehlercode %lu
 %s: konnte Signaldatei zum Logrotieren »%s« nicht entfernen: %m
 %s: konnte Signaldatei zum Befördern »%s« nicht entfernen: %m
 %s: konnte Signal zum Logrotieren nicht senden (PID: %d): %m
 %s: konnte Signal zum Befördern nicht senden (PID: %d): %m
 %s: konnte Signal zum Neuladen nicht senden (PID: %d): %m
 %s: konnte Signal %d nicht senden (PID: %d): %m
 %s: konnte Stopp-Signal nicht senden (PID: %d): %m
 %s: konnte Server nicht starten
Prüfen Sie die Logausgabe.
 %s: konnte Server wegen setsid()-Fehler nicht starten: %m
 %s: konnte Server nicht starten: %m
 %s: konnte Server nicht starten: Fehlercode %lu
 %s: konnte Systemdienst »%s« nicht starten: Fehlercode %lu
 %s: konnte Systemdienst »%s« nicht deregistrieren: Fehlercode %lu
 %s: konnte Signaldatei zum Logrotieren »%s« nicht schreiben: %m
 %s: konnte Signaldatei zum Befördern »%s« nicht schreiben: %m
 %s: Initialisierung des Datenbanksystems fehlgeschlagen
 %s: Verzeichnis »%s« existiert nicht
 %s: Verzeichnis »%s« ist kein Datenbankclusterverzeichnis
 %s: ungültige Daten in PID-Datei »%s«
 %s: fehlende Argumente für »kill«-Modus
 %s: kein Datenbankverzeichnis angegeben und Umgebungsvariable PGDATA nicht gesetzt
 %s: keine Operation angegeben
 %s: kein Server läuft
 %s: alter Serverprozess (PID: %d) scheint verschwunden zu sein
 %s: Optionsdatei »%s« muss genau eine Zeile haben
 %s: Speicher aufgebraucht
 %s: Befördern des Servers hat nicht rechtzeitig abgeschlossen
 %s: Starten des Servers hat nicht rechtzeitig abgeschlossen
 %s: Server fährt nicht herunter
 %s: Server läuft (PID: %d)
 %s: Systemdienst »%s« ist bereits registriert
 %s: Systemdienst »%s« ist nicht registriert
 %s: Einzelbenutzerserver läuft (PID: %d)
 %s: die PID-Datei »%s« ist leer
 %s: zu viele Kommandozeilenargumente (das erste ist »%s«)
 %s: unbekannter Operationsmodus »%s«
 %s: unbekannter Shutdown-Modus »%s«
 %s: unbekannter Signalname »%s«
 %s: unbekannter Starttyp »%s«
 TIPP: Die Option »-m fast« beendet Sitzungen sofort, statt auf das Beenden
durch die Sitzungen selbst zu warten.
 Wenn die Option -D weggelassen wird, dann wird die Umgebungsvariable
PGDATA verwendet.
 Läuft der Server?
 Bitte beenden Sie den Einzelbenutzerserver und versuchen Sie es noch einmal.
 Server wurde gestartet und nimmt Verbindungen an
 Zeitüberschreitung beim Warten auf Start des Servers
 Versuchen Sie »%s --help« für weitere Informationen.
 Aufruf:
 Warte auf Start des Servers...
 falsche Byte-Reihenfolge kann NULL-Zeiger nicht kopieren (interner Fehler)
 Kindprozess hat mit Code %d beendet Kindprozess hat mit unbekanntem Status %d beendet Kindprozess wurde durch Ausnahme 0x%X beendet Kindprozess wurde von Signal %d beendet: %s Befehl ist nicht ausführbar Befehl nicht gefunden konnte Befehl »%s« nicht ausführen: %m konnte kein »%s« zum Ausführen finden konnte aktuelles Arbeitsverzeichnis nicht ermitteln: %m
 konnte Programmdatei »%s« nicht lesen: %m konnte nicht von Befehl »%s« lesen: %m konnte Pfad »%s« nicht in absolute Form auflösen: %m ungültige Programmdatei »%s«: %m Befehl »%s« gab keine Daten zurück Speicher aufgebraucht Speicher aufgebraucht
 Programm »%s« wird von %s benötigt, aber wurde nicht im selben Verzeichnis wie »%s« gefunden
 Programm »%s« wurde von »%s« gefunden, aber es hatte nicht die gleiche Version wie %s
 Server wurde befördert
 Server wird befördert
 Server fährt herunter
 Signal an Server gesendet
 Signal zum Logrotieren an Server gesendet
 Server gestartet
 Server startet
 Server angehalten
 starte Server trotzdem
 versuche Server trotzdem zu starten
 warte auf Befördern des Servers... warte auf Herunterfahren des Servers... warte auf Start des Servers... 