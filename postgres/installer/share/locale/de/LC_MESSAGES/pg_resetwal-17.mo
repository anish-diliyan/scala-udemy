��    �      T  �   �      `     a  *   {  
   �     �  F   �       3   )  D   ]  ?   �  �   �  A   �  �   �  M   t  K   �  A     0   P  =   �  ;   �  (   �     $     8  +   S       )   �  )   �  )   �       )   *  )   T  +   ~  )   �  R   �  )   '  )   Q     {  7   �  U   �  5   &  A   \  )   �  )   �  )   �  ,     )   I  )   s  )   �  )   �  )   �  )     )   E  )   o  )   �  )   �  )   �  )     )   A  )   k  )   �  )   �  )   �  )        =  )   T  )   ~  )   �  )   �  :   �  )   7  %   a     �  )   �     �  ,   �  8   �     6     C     L     c  /   �  '   �  &   �  "   �     "  1   @     r     �  7   �  !   �  (   	     2  ,   O  :   |  !   �     �  (   �  0     &   P  8   w     �  3   �       "     )   B     l     u     }     �     �      �     �  &   �  +     )   =     g  7   �     �  -   �  >   �  )   ,     V     Y  ;   h  =   �  �   �  )        �   ,   �!  /   �!  D   "  7   Q"  (   �"     �"     �"  	   �"  �  �"     �$  (   �$     �$     �$  L   %  "   Z%  <   }%  M   �%  F   &  �   O&  J   '  �   c'  P   (  U   U(  R   �(  7   �(  C   6)  C   z)  .   �)     �)      *  2   *     R*  1   d*  0   �*  0   �*     �*  1   +  2   G+  2   z+  0   �+  _   �+  1   >,  1   p,     �,  ^   �,  t   !-  `   �-  O   �-  0   G.  0   x.  0   �.  3   �.  0   /  0   ?/  0   p/  0   �/  0   �/  0   0  0   40  0   e0  0   �0  0   �0  0   �0  1   )1  3   [1  0   �1  0   �1  0   �1  0   "2  0   S2     �2  0   �2  0   �2  0   3  0   23  E   c3  2   �3  7   �3     4  2   4  %   P4  3   v4  ?   �4     �4     �4     �4  *   5  2   <5  *   o5  /   �5  .   �5  (   �5  9   "6  &   \6  %   �6  B   �6  +   �6  /   7  %   H7  2   n7  H   �7  )   �7  #   8  3   88  <   l8  2   �8  ?   �8  6   9  >   S9  '   �9  $   �9  3   �9     :     :     %:     6:  #   =:  &   a:     �:  +   �:  0   �:  0   ;     2;  E   R;     �;  4   �;  ?   �;  0   <     B<     E<  G   \<  N   �<  �   �<  0   �=  I  �=  9   ?  7   Q?  G   �?  6   �?  .   @     7@     V@  	   r@     a   j       h       Q         G   v   F   +   D   z   :   *                        ~   @           [      "   x      E              Y   w   2       <         `          %           5   A   R   e      p                     Z   	       X   k       H             _   r   #   J       >   y       0       m   K   C   7          M   l   &   �   )              (   |   q       V                 �   ?               S   .   4   /   �   ,       !          9   U          b   s   �           c   �   6            =   t               �                 }   L   $          
      d   \   �   B   ;   �       1   ]       u   f   o   3       P   T   W   8   {   -       ^   N   g   O   i   I   '   n        

Values to be changed:

 
Options to override control file values:
 
Options:
 
Report bugs to <%s>.
       --wal-segsize=SIZE           size of WAL segments, in megabytes
   %s [OPTION]... DATADIR
   -?, --help             show this help, then exit
   -O, --multixact-offset=OFFSET    set next multitransaction offset
   -V, --version          output version information, then exit
   -c, --commit-timestamp-ids=XID,XID
                                   set oldest and newest transactions bearing
                                   commit timestamp (zero means no change)
   -e, --epoch=XIDEPOCH             set next transaction ID epoch
   -f, --force            force update to be done even after unclean shutdown or
                         if pg_control values had to be guessed
   -l, --next-wal-file=WALFILE      set minimum starting location for new WAL
   -m, --multixact-ids=MXID,MXID    set next and oldest multitransaction ID
   -n, --dry-run          no update, just show what would be done
   -o, --next-oid=OID               set next OID
   -u, --oldest-transaction-id=XID  set oldest transaction ID
   -x, --next-transaction-id=XID    set next transaction ID
  [-D, --pgdata=]DATADIR  data directory
 %s home page: <%s>
 %s must be in range %d..%d %s resets the PostgreSQL write-ahead log.

 64-bit integers Blocks per segment of large relation: %u
 Bytes per WAL segment:                %u
 Catalog version number:               %u
 Current pg_control values:

 Data page checksum version:           %u
 Database block size:                  %u
 Database system identifier:           %llu
 Date/time type storage:               %s
 File "%s" contains "%s", which is not compatible with this program's version "%s". First log segment after reset:        %s
 Float8 argument passing:              %s
 Guessed pg_control values:

 If these values seem acceptable, use -f to force reset. If you are sure the data directory path is correct, execute
  touch %s
and try again. If you want to proceed anyway, use -f to force reset. Is a server running?  If not, delete the lock file and try again. Latest checkpoint's NextMultiOffset:  %u
 Latest checkpoint's NextMultiXactId:  %u
 Latest checkpoint's NextOID:          %u
 Latest checkpoint's NextXID:          %u:%u
 Latest checkpoint's TimeLineID:       %u
 Latest checkpoint's full_page_writes: %s
 Latest checkpoint's newestCommitTsXid:%u
 Latest checkpoint's oldestActiveXID:  %u
 Latest checkpoint's oldestCommitTsXid:%u
 Latest checkpoint's oldestMulti's DB: %u
 Latest checkpoint's oldestMultiXid:   %u
 Latest checkpoint's oldestXID's DB:   %u
 Latest checkpoint's oldestXID:        %u
 Maximum columns in an index:          %u
 Maximum data alignment:               %u
 Maximum length of identifiers:        %u
 Maximum size of a TOAST chunk:        %u
 NextMultiOffset:                      %u
 NextMultiXactId:                      %u
 NextOID:                              %u
 NextXID epoch:                        %u
 NextXID:                              %u
 OID (-o) must not be 0 OldestMulti's DB:                     %u
 OldestMultiXid:                       %u
 OldestXID's DB:                       %u
 OldestXID:                            %u
 Resetting the write-ahead log might cause data to be lost. Size of a large-object chunk:         %u
 Try "%s --help" for more information. Usage:
 WAL block size:                       %u
 Write-ahead log reset
 You must run %s as the PostgreSQL superuser. argument of %s must be a power of two between 1 and 1024 by reference by value byte ordering mismatch cannot be executed by "root" cannot duplicate null pointer (internal error)
 could not allocate SIDs: error code %lu could not change directory to "%s": %m could not close directory "%s": %m could not close file "%s": %m could not create restricted token: error code %lu could not delete file "%s": %m could not fsync file "%s": %m could not get exit code from subprocess: error code %lu could not open directory "%s": %m could not open file "%s" for reading: %m could not open file "%s": %m could not open process token: error code %lu could not re-execute with restricted token: error code %lu could not read directory "%s": %m could not read file "%s": %m could not read file "%s": read %d of %zu could not read permissions of directory "%s": %m could not rename file "%s" to "%s": %m could not start process for command "%s": error code %lu could not stat file "%s": %m could not synchronize file system for file "%s": %m could not write file "%s": %m data directory is of wrong version database server was not shut down cleanly detail:  error:  fsync error: %m hint:  invalid argument for option %s invalid value "%s" for option %s lock file "%s" exists multitransaction ID (-m) must not be 0 multitransaction offset (-O) must not be -1 newestCommitTsXid:                    %u
 no data directory specified not proceeding because control file values were guessed off oldest multitransaction ID (-m) must not be 0 oldest transaction ID (-u) must be greater than or equal to %u oldestCommitTsXid:                    %u
 on out of memory
 pg_control exists but has invalid CRC; proceed with caution pg_control exists but is broken or wrong version; ignoring it pg_control specifies invalid WAL segment size (%d byte); proceed with caution pg_control specifies invalid WAL segment size (%d bytes); proceed with caution pg_control version number:            %u
 possible byte ordering mismatch
The byte ordering used to store the pg_control file might not match the one
used by this program.  In that case the results below would be incorrect, and
the PostgreSQL installation would be incompatible with this data directory. this build does not support sync method "%s" too many command-line arguments (first is "%s") transaction ID (-c) must be either %u or greater than or equal to %u transaction ID (-x) must be greater than or equal to %u transaction ID epoch (-e) must not be -1 unexpected empty file "%s" unrecognized sync method: %s warning:  Project-Id-Version: PostgreSQL 17
Report-Msgid-Bugs-To: pgsql-bugs@lists.postgresql.org
POT-Creation-Date: 2024-06-16 07:51+0000
PO-Revision-Date: 2024-03-26 11:01+0100
Last-Translator: Peter Eisentraut <peter@eisentraut.org>
Language-Team: German <pgsql-translators@postgresql.org>
Language: de
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
Plural-Forms: nplurals=2; plural=n != 1;
 

Zu ändernde Werte:

 
Optionen um Kontrolldateiwerte setzen:
 
Optionen:
 
Berichten Sie Fehler an <%s>.
       --wal-segsize=ZAHL           Größe eines WAL-Segments, in Megabytes
   %s [OPTION]... DATENVERZEICHNIS
   -?, --help             diese Hilfe anzeigen, dann beenden
   -O, --multixact-offset=OFFSET    nächsten Multitransaktions-Offset setzen
   -V, --version          Versionsinformationen anzeigen, dann beenden
   -c, --commit-timestamp-ids=XID,XID
                                   älteste und neuste Transaktion mit Commit-
                                   Timestamp setzen (Null bedeutet keine Änderung)
   -e, --epoch=XIDEPOCHE            nächste Transaktions-ID-Epoche setzen
   -f, --force            Änderung erzwingen, auch nach unsauberem Herunterfahren
                         oder wenn pg_control-Werte geschätzt werden mussten
   -l, --next-wal-file=WALDATEI     minimale Startposition für neuen WAL setzen
   -m, --multixact-ids=MXID,MXID    nächste und älteste Multitransaktions-ID setzen
   -n, --dry-run          keine Änderungen; nur zeigen, was gemacht werden würde
   -o, --next-oid=OID               nächste OID setzen
   -u, --oldest-transaction-id=XID  älteste Transaktions-ID setzen
   -x, --next-transaction-id=XID    nächste Transaktions-ID setzen
  [-D, --pgdata=]VERZ     Datenbankverzeichnis
 %s Homepage: <%s>
 %s muss im Bereich %d..%d sein %s setzt den PostgreSQL-Write-Ahead-Log zurück.

 64-Bit-Ganzzahlen Blöcke pro Segment:                          %u
 Bytes pro WAL-Segment:                       %u
 Katalogversionsnummer:                       %u
 Aktuelle pg_control-Werte:

 Datenseitenprüfsummenversion:                %u
 Datenbankblockgröße:                         %u
 Datenbanksystemidentifikation:               %llu
 Speicherung von Datum/Zeit-Typen:            %s
 Datei »%s« enthält »%s«, was nicht mit der Version dieses Programms »%s« kompatibel ist. Erstes Logdateisegment nach Zurücksetzen:    %s
 Übergabe von Float8-Argumenten:              %s
 Geschätzte pg_control-Werte:

 Wenn diese Werte akzeptabel scheinen, dann benutzen Sie -f, um das Zurücksetzen zu erzwingen. Wenn Sie sicher sind, dass das Datenverzeichnis korrekt ist, führen Sie
  touch %s
aus und versuchen Sie es erneut. Wenn Sie trotzdem weiter machen wollen, dann benutzen Sie -f, um das Zurücksetzen zu erzwingen. Läuft der Server?  Wenn nicht, dann Sperrdatei löschen und nochmal versuchen. NextMultiOffset des letzten Checkpoints:     %u
 NextMultiXactId des letzten Checkpoints:     %u
 NextOID des letzten Checkpoints:             %u
 NextXID des letzten Checkpoints:             %u:%u
 TimeLineID des letzten Checkpoints:          %u
 full_page_writes des letzten Checkpoints:    %s
 newestCommitTsXid des letzten Checkpoints:   %u
 oldestActiveXID des letzten Checkpoints:     %u
 oldestCommitTsXid des letzten Checkpoints:   %u
 DB des oldestMulti des letzten Checkpoints:  %u
 oldestMultiXid des letzten Checkpoints:      %u
 DB der oldestXID des letzten Checkpoints:    %u
 oldestXID des letzten Checkpoints:           %u
 Maximale Spalten in einem Index:             %u
 Maximale Datenausrichtung (Alignment):       %u
 Maximale Bezeichnerlänge:                    %u
 Maximale Größe eines Stücks TOAST:           %u
 NextMultiOffset:                             %u
 NextMultiXactId:                             %u
 NextOID:                                     %u
 NextXID-Epoche:                              %u
 NextXID:                                     %u
 OID (-o) darf nicht 0 sein OldestMulti's DB:                            %u
 OldestMultiXid:                              %u
 OldestXID's DB:                              %u
 OldestXID:                                   %u
 Beim Zurücksetzen des Write-Ahead-Logs können Daten verloren gehen. Größe eines Large-Object-Chunks:             %u
 Versuchen Sie »%s --help« für weitere Informationen. Aufruf:
 WAL-Blockgröße:                              %u
 Write-Ahead-Log wurde zurückgesetzt
 Sie müssen %s als PostgreSQL-Superuser ausführen. Argument von %s muss eine Zweierpotenz zwischen 1 und 1024 sein Referenz Wert falsche Byte-Reihenfolge kann nicht von »root« ausgeführt werden kann NULL-Zeiger nicht kopieren (interner Fehler)
 konnte SIDs nicht erzeugen: Fehlercode %lu konnte nicht in Verzeichnis »%s« wechseln: %m konnte Verzeichnis »%s« nicht schließen: %m konnte Datei »%s« nicht schließen: %m konnte beschränktes Token nicht erzeugen: Fehlercode %lu konnte Datei »%s« nicht löschen: %m konnte Datei »%s« nicht fsyncen: %m konnte Statuscode des Subprozesses nicht ermitteln: Fehlercode %lu konnte Verzeichnis »%s« nicht öffnen: %m konnte Datei »%s« nicht zum Lesen öffnen: %m konnte Datei »%s« nicht öffnen: %m konnte Prozess-Token nicht öffnen: Fehlercode %lu konnte Prozess nicht mit beschränktem Token neu starten: Fehlercode %lu konnte Verzeichnis »%s« nicht lesen: %m konnte Datei »%s« nicht lesen: %m konnte Datei »%s« nicht lesen: %d von %zu gelesen konnte Zugriffsrechte von Verzeichnis »%s« nicht lesen: %m konnte Datei »%s« nicht in »%s« umbenennen: %m konnte Prozess für Befehl »%s« nicht starten: Fehlercode %lu konnte »stat« für Datei »%s« nicht ausführen: %m konnte Dateisystem für Datei »%s« nicht synchronisieren: %m konnte Datei »%s« nicht schreiben: %m Datenverzeichnis hat falsche Version Datenbankserver wurde nicht sauber heruntergefahren Detail:  Fehler:  fsync-Fehler: %m Tipp:  ungültiges Argument für Option %s ungültiger Wert »%s« für Option %s Sperrdatei »%s« existiert Multitransaktions-ID (-m) darf nicht 0 sein Multitransaktions-Offset (-O) darf nicht -1 sein newestCommitTsXid:                           %u
 kein Datenverzeichnis angegeben es wird nicht fortgefahren, weil Kontrolldateiwerte geschätzt wurden aus älteste Multitransaktions-ID (-m) darf nicht 0 sein älteste Transaktions-ID (-u) muss größer oder gleich %u sein oldestCommitTsXid:                           %u
 an Speicher aufgebraucht
 pg_control existiert, aber mit ungültiger CRC; mit Vorsicht fortfahren pg_control existiert, aber ist kaputt oder hat falsche Version; wird ignoriert pg_control gibt ungültige WAL-Segmentgröße an (%d Byte); mit Vorsicht fortfahren pg_control gibt ungültige WAL-Segmentgröße an (%d Bytes); mit Vorsicht fortfahren pg_control-Versionsnummer:                   %u
 möglicherweise falsche Byte-Reihenfolge
Die Byte-Reihenfolge, die zur Speicherung der Datei pg_control verwendet wurde,
stimmt möglicherweise nicht mit der von diesem Programm verwendeten überein. In
diesem Fall wären die Ergebnisse unten falsch und die PostgreSQL-Installation
wäre inkompatibel mit diesem Datenverzeichnis. diese Installation unterstützt Sync-Methode »%s« nicht zu viele Kommandozeilenargumente (das erste ist »%s«) Transaktions-ID (-c) muss entweder %u oder größer oder gleich %u sein Transaktions-ID (-x) muss größer oder gleich %u sein Transaktions-ID-Epoche (-e) darf nicht -1 sein unerwartete leere Datei »%s« unbekannte Sync-Methode: %s Warnung:  