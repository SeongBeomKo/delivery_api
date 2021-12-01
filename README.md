# Delivery API

**[요구사항]**

1. 음식점 등록 및 조회
2. 음식 등록 및 메뉴판 조회
3. 주문하기



### 음식점 등록 및 조회

- 음식점 정보 입력받아 등록
    1. 음식점 이름 (name)
    2. 최소주문 가격 (minOrderPrice)
        1. 허용값: 1,000원 ~ 100,000원 입력
        2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원은 입력 가능)
        3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
    3. 기본 배달비 (deliveryFee)
        1. 허용값: 0원 ~ 10,000원
        2. 500 원 단위로만 입력 가능 (예. 2,200원 입력 시 에러발생. 2,500원 입력 가능) 
        3. 허용값이 아니거나 1,000원 단위 입력이 아닌 경우 에러 발생시킴
        
- 음식점 조회
    - 등록된 모든 음식점 정보 조회 가능
        1. 등록 시 입력한 음식점 정보 (name, minOrderPrice, deliveryFee)
        2. DB 테이블 ID (id)
        
### 음식 등록 및 메뉴판 조회

- 음식점 ID 및 음식 정보 입력받아 등록
    1. 음식점 ID (restaurantId)
        1. 음식점 DB 테이블 ID
    2. 음식명 (name)
        1. 같은 음식점 내에서는 음식 이름이 중복될 수 없음 (예. '자담치킨 강남점'에 '후라이드치킨' 이 이미 등록되어 있다면 중복하여 등록할 수 없지만, 다른 음식점인 '맘스터치 강남점'에는 '후라이드치킨' 을 등록 가능)
    3. 가격 (price)
        1. 허용값: 100원 ~ 1,000,000원
        2. 100 원 단위로만 입력 가능 (예. 2,220원 입력 시 에러발생. 2,300원 입력 가능)
        3. 허용값이 아니거나 100원 단위 입력이 아닌 경우 에러 발생시킴
        
- 메뉴판 조회
    - 하나의 음식점에 등록된 모든 음식 정보 조회
        1. 등록 시 입력한 음식 정보 (name, price)
        2. DB 테이블 ID (id)
        
 
 ### 주문요청하기 및 주문 조회
 
 - 주문 요청 시 배달 음식점 및 음식 정보 입력받음
    1. 음식점 ID (restaurantId)
    2. 음식 주문 정보 (foods)
        1. 음식 ID (id)
        2. 음식을 주문할 수량 (quantity)
            1. 허용값: 1 ~ 100
            2. 허용값이 아니면 에러 발생시킴
            
- 주문 요청에 대한 응답으로 다음 정보를 포함시킴
    1. 주문 음식점 이름 (restaurantName)
    2. 주문 음식 정보 (foods)
        - 주문 음식명 (name)
        - 주문 수량 (quantity)
        - 주문 음식의 가격 (price)
            - 계산방법
                - 주문 음식 1개의 가격 * 주문 수량
    3. 배달비 (deliveryFee)
        - 주문 음식점의 기본 배달비
    4. 최종 결제 금액 (totalPrice)
        - 계산방법
            - 주문 음식 가격들의 총 합 + 배달비
        - "주문 음식 가격들의 총 합" 이 주문 음식점의 "최소주문 가격" 을 넘지 않을 시 에러 발생시킴
        
- 주문 조회
    - 그동안 성공한 모든 주문 요청을 조회 가능
    
 
<img width="602" alt="화면 캡처 2021-12-02 021114" src="https://user-images.githubusercontent.com/22443546/144281205-dd30ee28-08af-464a-8e76-acaadb0d7b33.png">
<img width="583" alt="화면 캡처 2021-12-02 021620" src="https://user-images.githubusercontent.com/22443546/144281801-c7825535-3ef0-42f8-9d66-c464846f99f1.png">
<img width="575" alt="화면 캡처 2021-12-02 021601" src="https://user-images.githubusercontent.com/22443546/144281815-5aee754e-20cf-44d5-b5dc-34167f3507cc.png">
<img width="518" alt="화면 캡처 2021-12-02 021222" src="https://user-images.githubusercontent.com/22443546/144281295-b7f6c256-2c99-4a90-ad81-7ed6f5ce03cf.png">
<img width="514" alt="화면 캡처 2021-12-02 021245" src="https://user-images.githubusercontent.com/22443546/144281314-877dbd2d-9a41-4e58-8415-80dd3efce3bb.png">

