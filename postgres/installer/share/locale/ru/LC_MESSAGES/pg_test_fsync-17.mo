��    &      L  5   |      P  1   Q  2   �  /   �     �  8        :     T     o     �     �     �     �  (   �  U     [   f  M   �  c        t  .   �  F   �  E     %   K  +   q  /   �  !   �     �     
               (     /     N     R     W  /   f  	   �     �    �     �
     4  n   �  @   #  �   d  &   �  &     &   ;  &   b  %   �  F   �     �  �   �  �   �  �   U  �     �   �  &   �  e   �  k   3  o   �  Z     L   j  p   �  X   (  <   �     �     �  /   �       ?   +     k     q     x  c   �     �          $          
   #                         "                    !             &                  	                                                                    %                
Compare file sync methods using one %dkB write:
 
Compare file sync methods using two %dkB writes:
 
Compare open_sync with different write sizes:
 
Non-sync'ed %dkB writes:
 
Test if fsync on non-write file descriptor is honored:
  1 * 16kB open_sync write  2 *  8kB open_sync writes  4 *  4kB open_sync writes  8 *  2kB open_sync writes %13.3f ops/sec  %6.0f usecs/op
 %s must be in range %u..%u %s: %m %u second per test
 %u seconds per test
 (If the times are similar, fsync() can sync data written on a different
descriptor.)
 (This is designed to compare the cost of writing 16kB in different write
open_sync sizes.)
 (in "wal_sync_method" preference order, except fdatasync is Linux's default)
 * This file system and its mount options do not support direct
  I/O, e.g. ext4 in journaled mode.
 16 *  1kB open_sync writes Direct I/O is not supported on this platform.
 F_NOCACHE supported on this platform for open_datasync and open_sync.
 O_DIRECT supported on this platform for open_datasync and open_sync.
 Try "%s --help" for more information. Usage: %s [-f FILENAME] [-s SECS-PER-TEST]
 cannot duplicate null pointer (internal error)
 could not create thread for alarm could not open output file detail:  error:  fsync failed hint:  invalid argument for option %s n/a n/a* out of memory
 too many command-line arguments (first is "%s") warning:  write failed Project-Id-Version: pg_test_fsync (PostgreSQL) 10
Report-Msgid-Bugs-To: pgsql-bugs@lists.postgresql.org
POT-Creation-Date: 2024-09-02 09:29+0300
PO-Revision-Date: 2024-09-04 18:11+0300
Last-Translator: Alexander Lakhin <exclusion@gmail.com>
Language-Team: Russian <pgsql-ru-general@postgresql.org>
Language: ru
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
Plural-Forms: nplurals=3; plural=(n%10==1 && n%100!=11 ? 0 : n%10>=2 && n%10<=4 && (n%100<10 || n%100>=20) ? 1 : 2);
 
Сравнение методов синхронизации файлов при однократной записи %d КБ:
 
Сравнение методов синхронизации файлов при двухкратной записи %d КБ:
 
Сравнение open_sync при различных объёмах записываемых данных:
 
Несинхронизированная запись %d КБ:
 
Проверка, производится ли fsync с указателем файла, открытого не для записи:
 запись с open_sync  1 * 16 КБ запись с open_sync  2 *  8 КБ запись с open_sync  4 *  4 КБ запись с open_sync  8 *  2 КБ %13.3f оп/с     %6.0f мкс/оп
 значение %s должно быть в диапазоне %u..%u %s: %m на тест отводится %u сек.
 на тест отводится %u сек.
 на тест отводится %u сек.
 (Если длительность примерно одинаковая, fsync() может синхронизировать данные,
записанные через другой дескриптор.)
 (Этот тест предназначен для сравнения стоимости записи 16 КБ при разных размерах
записи с open_sync.)
 (в порядке предпочтения для "wal_sync_method", за исключением того, что в Linux предпочитается fdatasync)
 * Эта файловая система с текущими параметрами монтирования не поддерживает
  прямой ввод/вывод, как например, ext4 в режиме журналирования.
 запись с open_sync 16 *  1 КБ Прямой ввод/вывод не поддерживается на этой платформе.
 F_NOCACHE на этой платформе поддерживается для open_datasync и open_sync.
 O_DIRECT на этой платформе не поддерживается для open_datasync и open_sync.
 Для дополнительной информации попробуйте "%s --help". Использование: %s [-f ИМЯ_ФАЙЛА ] [-s ТЕСТ_СЕК]
 попытка дублирования нулевого указателя (внутренняя ошибка)
 не удалось создать поток для обработки сигналов не удалось открыть выходной файл подробности:  ошибка:  ошибка синхронизации с ФС подсказка:  недопустимый аргумент параметра %s н/д н/д* нехватка памяти
 слишком много аргументов командной строки (первый: "%s") предупреждение:  ошибка записи 