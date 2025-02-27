��            )         �  �   �  
   �  �   �       3   5  8   i  D   �  L   �  C   4  w   x  w   �     h  6   |  %   �     �  $   �  /     )   6  (   `  (   �     �     �     �     �     �       !   "     D     S  	   s  �  }  �   #       �   2  9     p   P  [   �  n     �   �  �     �   �  �   H  )   �  K   '  P   s     �  @   �  l      R   �  T   �  V   5  6   �     �     �     �  >   �  G   5  Z   }  %   �  P   �     O                   	                                                    
                                                                 
For use as archive_cleanup_command in postgresql.conf:
  archive_cleanup_command = 'pg_archivecleanup [OPTION]... ARCHIVELOCATION %%r'
e.g.
  archive_cleanup_command = 'pg_archivecleanup /mnt/server/archiverdir %%r'
 
Options:
 
Or for use as a standalone archive cleaner:
e.g.
  pg_archivecleanup /mnt/server/archiverdir 000000010000000000000010.00000020.backup
 
Report bugs to <%s>.
   %s [OPTION]... ARCHIVELOCATION OLDESTKEPTWALFILE
   -?, --help                  show this help, then exit
   -V, --version               output version information, then exit
   -b, --clean-backup-history  clean up files including backup history files
   -d, --debug                 generate debug output (verbose mode)
   -n, --dry-run               dry run, show the names of the files that would be
                              removed
   -x, --strip-extension=EXT   strip this extension before identifying files for
                              clean up
 %s home page: <%s>
 %s removes older WAL files from PostgreSQL archives.

 Try "%s --help" for more information. Usage:
 archive location "%s" does not exist cannot duplicate null pointer (internal error)
 could not close archive location "%s": %m could not open archive location "%s": %m could not read archive location "%s": %m could not remove file "%s": %m detail:  error:  hint:  invalid file name argument must specify archive location must specify oldest kept WAL file out of memory
 too many command-line arguments warning:  Project-Id-Version: postgresql
Report-Msgid-Bugs-To: pgsql-bugs@lists.postgresql.org
POT-Creation-Date: 2024-08-31 06:23+0000
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
X-Crowdin-File: /REL_17_STABLE/pg_archivecleanup.pot
X-Crowdin-File-ID: 1032
 
Для використання як archive_cleanup_command у postgresql.conf:
  archive_cleanup_command = 'pg_archivecleanup [OPTION]... ARCHIVELOCATION %%r'
напр.
  archive_cleanup_command = 'pg_archivecleanup /mnt/server/archiverdir %%r'
 
Параметри:
 
Або для використання в якості окремого засобу для чистки архівів,
наприклад:
  pg_archivecleanup /mnt/server/archiverdir 000000010000000000000010.00000020.backup
 
Повідомляти про помилки на <%s>.
   %s [OPTION]... РОЗТАШУВАННЯ_АРХІВА НАЙДАВНІШИЙ_ЗБЕРЕЖЕНИЙ_WAL_ФАЙЛ
   -?, --help                   показати цю довідку, потім вийти
   -V, --version                вивести інформацію про версію, потім вийти
   -b, --clean-backup-history  очистити файли, включаючи файли історії резервного копіювання
   -d, --debug                 генерувати налагоджувальний вивід (розгорнутий режим)
   -n, --dry-run               сухий запуск, показати назви файлів, які будуть
                              вилучені
   -x, --strip-extension=EXT   вилучати це розширення перед ідентифікацією файлів для
                              очищення
 Домашня сторінка %s: <%s>
 %s видаляє старі WAL-файли з архівів PostgreSQL.

 Спробуйте "%s --help" для додаткової інформації. Використання:
 архівного розташування "%s" не існує неможливо дублювати нульовий покажчик (внутрішня помилка)
 не вдалося закрити архівне розташування "%s":%m не вдалося відкрити архівне розташування "%s":%m не вдалося прочитати архівне розташування "%s":%m не можливо видалити файл "%s": %m деталі:  помилка:  підказка:  недійсна назва файла з аргументом необхідно вказати розташування архіва необхідно вказати найдавніший збережений WAL-файл недостатньо пам'яті
 занадто багато аргументів командного рядка попередження:  