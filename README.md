validation-api 內建的 constraint 清單
Constraint	詳細資訊
@AssertFalse	被註釋的元素必須為 false
@AssertTrue	同@AssertFalse
@DecimalMax	被註釋的元素必須是一個數字，其值必須小於等於指定的最大值
@DecimalMin	同DecimalMax
@Digits	帶批註的元素必須是一個在可接受範圍內的數字
@Email	顧名思義
@Future	將來的日期
@FutureOrPresent	現在或將來
@Max	被註釋的元素必須是一個數字，其值必須小於等於指定的最大值
@Min	被註釋的元素必須是一個數字，其值必須大於等於指定的最小值
@Negative	帶註釋的元素必須是一個嚴格的負數（0為無效值）
@NegativeOrZero	帶註釋的元素必須是一個嚴格的負數（包含0）
@NotBlank	同StringUtils.isNotBlank
@NotEmpty	同StringUtils.isNotEmpty
@NotNull	不能是Null
@Null	元素是Null
@Past	被註釋的元素必須是一個過去的日期
@PastOrPresent	過去和現在
@Pattern	被註釋的元素必須符合指定的正則表示式
@Positive	被註釋的元素必須嚴格的正數（0為無效值）
@PositiveOrZero	被註釋的元素必須嚴格的正數（包含0）
@Szie	帶註釋的元素大小必須介於指定邊界（包括）之間
Hibernate Validator 附加的 constraint
Constraint	詳細資訊
@Email	被註釋的元素必須是電子郵箱地址
@Length	被註釋的字串的大小必須在指定的範圍內
@NotEmpty	被註釋的字串的必須非空
@Range	被註釋的元素必須在合適的範圍內
CreditCardNumber	被註釋的元素必須符合信用卡格式