��    �      T  �   �      `     a  *   {  
   �     �  F   �       3   )  D   ]  ?   �  �   �  A   �  �   �  M   t  K   �  A     0   P  =   �  ;   �  (   �     $     8  +   S       )   �  )   �  )   �       )   *  )   T  +   ~  )   �  R   �  )   '  )   Q     {  7   �  U   �  5   &  A   \  )   �  )   �  )   �  ,     )   I  )   s  )   �  )   �  )   �  )     )   E  )   o  )   �  )   �  )   �  )     )   A  )   k  )   �  )   �  )   �  )        =  )   T  )   ~  )   �  )   �  :   �  )   7  %   a     �  )   �     �  ,   �  8   �     6     C     L     c  /   �  '   �  &   �  "   �     "  1   @     r     �  7   �  !   �  (   	     2  ,   O  :   |  !   �     �  (   �  0     &   P  8   w     �  3   �       "     )   B     l     u     }     �     �      �     �  &   �  +     )   =     g  7   �     �  -   �  >   �  )   ,     V     Y  ;   h  =   �  �   �  )        �   ,   �!  /   �!  D   "  7   Q"  (   �"     �"     �"  	   �"  �  �"  ;   �%  d   �%     5&  9   K&  `   �&     �&  U    '  m   V'  a   �'  ,  &(  l   S)    �)  �   �*  �   O+  u   �+  G   G,  _   �,  [   �,  8   K-  )   �-  /   �-  A   �-      .  K   7.  )   �.  ;   �.  -   �.  P   /  0   h/  R   �/  ,   �/  s   0  R   �0  4   �0  3   1  �   I1  �   �1  �   �2  �   3  G   �3  G   �3  ?   +4  A   k4  B   �4  H   �4  I   95  G   �5  H   �5  W   6  G   l6  W   �6  A   7  Q   N7  ?   �7  J   �7  A   +8  )   m8  *   �8  +   �8  .   �8  *   9  !   H9  )   j9  )   �9  *   �9  )   �9     :  B   �:  P   �:     ';     B;  3   b;  T   �;  j   �;     V<     p<  4   �<  .   �<  l   �<  C   Y=  ?   �=  :   �=  3   >  ]   L>  6   �>  +   �>  p   ?  <   ~?  L   �?  6   @  Y   ?@  n   �@  >   A  8   GA  R   �A  R   �A  J   &B  i   qB  T   �B  i   0C  6   �C  ?   �C  S   D     eD     tD     �D     �D  H   �D  K   �D  4   FE  G   {E  N   �E  *   F  -   =F  z   kF     �F  \   �F  i   LG  (   �G  
   �G  %   �G  s   H  s   �H  ]  �H  2   VK    �K  T   �M  \   �M  �   =N  P   �N  G   O  7   YO  D   �O     �O     a   j       h       Q         G   v   F   +   D   z   :   *                        ~   @           [      "   x      E              Y   w   2       <         `          %           5   A   R   e      p                     Z   	       X   k       H             _   r   #   J       >   y       0       m   K   C   7          M   l   &   �   )              (   |   q       V                 �   ?               S   .   4   /   �   ,       !          9   U          b   s   �           c   �   6            =   t               �                 }   L   $          
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
the PostgreSQL installation would be incompatible with this data directory. this build does not support sync method "%s" too many command-line arguments (first is "%s") transaction ID (-c) must be either %u or greater than or equal to %u transaction ID (-x) must be greater than or equal to %u transaction ID epoch (-e) must not be -1 unexpected empty file "%s" unrecognized sync method: %s warning:  Project-Id-Version: postgresql
Report-Msgid-Bugs-To: pgsql-bugs@lists.postgresql.org
POT-Creation-Date: 2024-08-31 06:21+0000
PO-Revision-Date: 2024-09-23 19:38
Last-Translator: 
Language-Team: Ukrainian
Language: uk_UA
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
Plural-Forms: nplurals=4; plural=((n%10==1 && n%100!=11) ? 0 : ((n%10 >= 2 && n%10 <=4 && (n%100 < 12 || n%100 > 14)) ? 1 : ((n%10 == 0 || (n%10 >= 5 && n%10 <=9)) || (n%100 >= 11 && n%100 <= 14)) ? 2 : 3));
X-Crowdin-Project: postgresql
X-Crowdin-Project-ID: 324573
X-Crowdin-Language: uk
X-Crowdin-File: /REL_17_STABLE/pg_resetwal.pot
X-Crowdin-File-ID: 1010
 

Значення, що потребують зміни:

 
Опції для перевизначення значень контрольного файлу:
 
Параметри:
 
Повідомляти про помилки на <%s>.
       --wal-segsize=SIZE           розмір сегментів WAL, у мегабайтах
   %s [OPTION]... DATADIR
   -?, --help              показати цю довідку потім вийти
   -O, --multixact-offset=OFFSET    задати зсув наступної мультитранзакції
   -V, --version            вивести інформацію про версію і вийти
   -c, --commit-timestamp-ids=XID,XID
                                   встановити найстарішу та найновішу транзакції
                                   затвердити позначку часу (нуль означає залишити без змін)
   -e, --epoch=XIDEPOCH             встановити наступну епоху ID транзакцій
   -f, --force            змусити оновлення виконуватися навіть після нечистого вимкнення або
                         якщо значення pg_control потрібно було вгадувати
   -l, --next-wal-file=WALFILE      задати мінімальне початкове розташування для нового WAL
   -m, --multixact-ids=MXID,MXID    задати ID наступної і найстарішої мультитранзакції
   -n, --dry-run          не оновлювати, просто показати, що було б зроблено
   -o, --next-oid=OID               задати наступний OID
   -u, --oldest-transaction-id=XID  задати ID найстарішої транзакції
   -x, --next-transaction-id=XID    задати ID наступної транзакції
  [-D, --pgdata=]DATADIR  каталог з даними
 Домашня сторінка %s: <%s>
 %s має бути в діапазоні %d..%d %s скидає журнал передзапису PostgreSQL.

 64-бітні цілі Блоків на сегмент великого відношення: %u
 Байтів на сегмент WAL: %u
 Номер версії каталогу:               %u
 Поточні значення pg_control:

 Версія контрольних сум сторінок даних:      %u
 Розмір блоку бази даних: %u
 Системний ідентифікатор бази даних:           %llu
 Дата/час типу сховища: %s
 Файл "%s" містить "%s", який не сумісний з версією цієї програми "%s". Перший сегмент журналу після скидання:        %s
 Передача аргументу Float8:      %s
 Припустимі значення pg_control:

 Якщо ці значення здаються прийнятними, використовуйте -f для примусового скидання. Якщо Ви впевнені, що шлях каталогу даних є правильним, виконайте 
 touch %s
і спробуйте знову. Якщо ви все одно хочете продовжити, використовуйте -f для примусового скидання. Чи запущений сервер? Якщо ні, видаліть файл блокування і спробуйте знову. Останній NextMultiOffset контрольної точки: %u
 Останній NextMultiXactId контрольної точки: %u
 Останній NextOID контрольної точки: %u
 Останній NextXID контрольної точки: %u%u
 Останній TimeLineID контрольної точки: %u
 Останній full_page_writes контрольної точки: %s
 Останній newestCommitTsXid контрольної точки: %u
 Останній oldestActiveXID контрольної точки: %u
 Останній oldestCommitTsXid контрольної точки:%u
 Остання DB останньої oldestMulti контрольної точки: %u
 Останній oldestMultiXid контрольної точки: %u 
 Остання DB останнього oldestXID контрольної точки: %u
 Останній oldestXID контрольної точки: %u
 Максимальна кількість стовпців в індексі: %u
 Максимальне вирівнювання даних: %u
 Максимальна довжина ідентифікаторів:  %u
 Максимальний розмір сегменту TOAST: %u
 NextMultiOffset:                      %u
 NextMultiXactId:                       %u
 NextOID:                                %u
 Епоха NextXID:                        %u
 NextXID:                               %u
 OID (-o) не може бути 0 OldestMulti's DB:                     %u
 OldestMultiXid:                       %u
 OldestXID's DB:                        %u
 OldestXID:                            %u
 Скидання журналу попереднього запису може призвести до втрати даних. Розмір сегменту великих обїєктів: %u
 Спробуйте "%s --help" для додаткової інформації. Використання:
 Pозмір блоку WAL: %u
 Журнал передзапису скинуто
 Запускати %s треба від суперкористувача PostgreSQL. аргумент %s має бути ступенем двійки в діапазоні від 1 до 1024 за посиланням за значенням неправильний порядок байтів "root" не може це виконувати неможливо дублювати нульовий покажчик (внутрішня помилка)
 не вдалося виділити SID: код помилки %lu не вдалося змінити каталог на "%s": %m не вдалося закрити каталог "%s": %m неможливо закрити файл "%s": %m не вдалося створити обмежений токен: код помилки %lu не вдалося видалити файл "%s": %m не вдалося fsync файл "%s": %m не вдалося отримати код завершення підпроцесу: код помилки %lu не вдалося відкрити каталог "%s": %m не вдалося відкрити файл "%s" для читання: %m не можливо відкрити файл "%s": %m не вдалося відкрити токен процесу: код помилки %lu не вдалося перезапустити з обмеженим токеном: код помилки %lu не вдалося прочитати каталог "%s": %m не вдалося прочитати файл "%s": %m не вдалося прочитати файл "%s": прочитано %d з %zu не вдалося прочитати дозволи на каталог "%s": %m не вдалося перейменувати файл "%s" на "%s": %m не вдалося запустити процес для команди "%s": код помилки %lu не вдалося отримати інформацію від файлу "%s": %m не вдалося синхронізувати файлову систему для файлу "%s": %m не вдалося записати файл "%s": %m каталог даних неправильної версії сервер бази даних завершив роботу некоректно деталі:  помилка:  помилка fsync: %m підказка:  неприпустимий аргумент для параметру %s неприпустиме значення "%s" для параметра %s файл блокування "%s" вже існує ID мультитранзакції (-m) не повинен бути 0 зсув мультитранзакції (-O) не повинен бути -1 newestCommitTsXid:                     %u
 каталог даних не вказано не виконується, оскільки значення контрольного файлу були вгадані вимк найстарший ID мультитранзакції (-m) не повинен бути 0 найстаріший ID транзакції (-u) має бути більший або рівним %u oldestCommitTsXid:                   %u
 увімк недостатньо пам'яті
 pg_control існує, але має недопустимий CRC; продовжуйте з обережністю pg_control існує, але зламаний або неправильної версії; ігнорується pg_control вказує неприпустимий розмір сегмента WAL (%d байт); продовжуйте з обережністю pg_control вказує неприпустимий розмір сегмента WAL (%d байти); продовжуйте з обережністю pg_control вказує неприпустимий розмір сегмента WAL (%d байтів); продовжуйте з обережністю pg_control вказує неприпустимий розмір сегмента WAL (%d байтів); продовжуйте з обережністю pg_control номер версії:            %u
 можлива помилка у послідовності байтів.
Порядок байтів, що використовують для зберігання файлу pg_control, може не відповідати тому, який використовується цією програмою. У такому випадку результати нижче будуть неправильним, і інсталяція PostgreSQL буде несумісною з цим каталогом даних. ця збірка не підтримує метод синхронізації "%s" забагато аргументів у командному рядку (перший "%s") ідентифікатор транзакції (-c) має бути або %u, або більше чи дорівнювати %u ID транзакції (-x) має бути більшим чи рівним %u епоха ID транзакції (-e) не повинна бути -1 неочікуваний порожній файл "%s" нерозпізнаний метод синхронізації: %s попередження:  