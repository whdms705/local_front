# Front Project



### 사용

- spring boot 2.3.4.RELEASE
- redis


---


## 기타정리


### 캐시란

- 캐시란 데이터를 임시로 저장해두는 장소를 말합니다.

- 네트워크(통신)에 대한 부담,DB에 접속하지 않고 데이터를 갖고있어 부담을 줄이고 성능을 높여줍니다.

- 80:20 법칙에 따라 20%의 데이터가 전체 조회 건수의 80%를 차지할 경우 캐시를 사용이 적합함


---


### Redis vs Memcached

Redis 장점

- 디스크에 데이터를 기록하고 있기 때문에, Redis 메모리가 날라가도 데이터를 복구 가능

( 스냅샷을 떠서, 이를 사용하는 RDB 방식과 Write / Update Event를 로그에 남겨서 이를 기반으로 복구하는 AOF 방식 두가지가 있다. )

- 다양한 데이터 포맷을 지원

  String, List, Set, Sorted sets, Hash 등의 데이터 포맷을 지원기능을 간편하게 구현할 수 있다. 예를 뜰면 BITMAP 데이터 구조와 BITCOUNT 함수를 사용하면 일일 유니크 방문자수를 간단하게 구현할 수 있다.  ( 참고 - REDIS - 3.6 BITMAP )

- 데이터 삭제 정책이 다양

Memcached는 LRU 삭제 정책만 지원한다고 한다.

- 한 개의 키에 저장할 수 있는 VALUE의 범위가 Memcached에 비해 더 크다. 

Redis는 512MB인 반면, memcached는 1MB까지 저장할 수 있다. 





Redis 단점

- 메모리를 2배로 사용

   레디스는 싱글 스레드이다. 그래서 스냅샷을 뜰 때, 자식 프로세스를 하나 만들낸 후 

   새로 변경된 메모리 페이지를 복사해서 사용한다.

   레디스는 copy-on-write 방식을 사용하고 있지만, 

   보통 레디스를 사용할 때는 데이터 변경이 잦기 때문에 실제 메모리 양만큼의 메모리를 자식 프로세스가 복사하게 된다.

   그래서 실제로 필요한 메모리 양보다 더 많은 메모리를 사용하게 된다.

- 레디스는 메모리를 직접 처리할 수 없어서, 메모리 파편화가 발생하기 쉽다.



Memcached 장점

- memcached는 DB / API 통신을 줄이기 위해 데이터를 캐싱처리하는 데에 사용하면 좋은 캐시

- 레디스는 트래픽이 몰리면, 응답속도가 불안정하다고 한다.

   반면, 트래픽이 몰려도 Memcached의 응답 속도는 안정적인 편이라고 한다. 

- memcached는 내부적으로 slab 할당자를 사용하고 있어서, 메모리 파편화 문제가 덜하다.

   그러나,  데이터 변경이 잦은 경우, 메모리 파편화가 발생하기 쉽다. 때문에 memcached는 한 번 입력후, 변경되지 않는 정보를 저장할 때 유용하다.

- 레디스에 비하면 메타 데이터를 적게 사용하기 때문에 메모리 사용량이 상대적으로 낮다. 


Memcached 단점

- 레디스처럼 데이터 타입과 API가 다양하지 않다. 


---


## 출저
ttps://americanopeople.tistory.com/148 [복세편살]
