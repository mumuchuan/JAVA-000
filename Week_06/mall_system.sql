-- 用户信息表(customer_inf)
drop table if exists mall_system.customer_inf;
CREATE TABLE mall_system.customer_inf (
customer_inf_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
customer_id INT UNSIGNED NOT NULL COMMENT 'customer_login表的自增ID',
customer_name VARCHAR ( 20 ) NOT NULL COMMENT '用户真实姓名',
identity_card_type TINYINT NOT NULL DEFAULT 1 COMMENT '证件类型：1 身份证，2 军官证，3 护照',
identity_card_no VARCHAR ( 20 ) COMMENT '证件号码',
mobile_phone INT UNSIGNED COMMENT '手机号',
customer_email VARCHAR ( 50 ) COMMENT '邮箱',
gender CHAR ( 1 ) COMMENT '性别',
user_point INT NOT NULL DEFAULT 0 COMMENT '用户积分',
register_time bigint(20) DEFAULT '0'  COMMENT '注册时间',
birthday bigint(20) DEFAULT '0'  COMMENT '会员生日',
customer_level TINYINT NOT NULL DEFAULT 1 COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
user_money DECIMAL ( 8, 2 ) NOT NULL DEFAULT 0.00 COMMENT '用户余额',
modified_time bigint(20) DEFAULT '0'  COMMENT '最后修改时间',
PRIMARY KEY pk_customerinfid ( customer_inf_id ) 
) engine=InnoDB default charset=utf8 COMMENT '用户信息表';


-- 商品信息表(product_info)
drop table if exists mall_system.product_info;
CREATE TABLE mall_system.product_info (
product_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品ID',
product_core CHAR ( 16 ) NOT NULL COMMENT '商品编码',
product_name VARCHAR ( 20 ) NOT NULL COMMENT '商品名称',
bar_code VARCHAR ( 50 ) NOT NULL COMMENT '国条码',
brand_id INT UNSIGNED NOT NULL COMMENT '品牌表的ID',
one_category_id SMALLINT UNSIGNED NOT NULL COMMENT '一级分类ID',
two_category_id SMALLINT UNSIGNED NOT NULL COMMENT '二级分类ID',
three_category_id SMALLINT UNSIGNED NOT NULL COMMENT '三级分类ID',
supplier_id INT UNSIGNED NOT NULL COMMENT '商品的供应商ID',
price DECIMAL ( 8, 2 ) NOT NULL COMMENT '商品销售价格',
average_cost DECIMAL ( 18, 2 ) NOT NULL COMMENT '商品加权平均成本',
publish_status TINYINT NOT NULL DEFAULT 0 COMMENT '上下架状态：0下架1上架',
audit_status TINYINT NOT NULL DEFAULT 0 COMMENT '审核状态：0未审核，1已审核',
weight FLOAT COMMENT '商品重量',
length FLOAT COMMENT '商品长度',
height FLOAT COMMENT '商品高度',
width FLOAT COMMENT '商品宽度',
color_type ENUM ( '红', '黄', '蓝', '黑' ),
production_date bigint(20) DEFAULT '0'  COMMENT '生产日期',
shelf_life INT NOT NULL COMMENT '商品有效期',
descript TEXT NOT NULL COMMENT '商品描述',
indate bigint(20) DEFAULT '0'   COMMENT '商品录入时间',
modified_time bigint(20) DEFAULT '0'  COMMENT '最后修改时间',
PRIMARY KEY pk_productid ( product_id ) 
) engine=InnoDB default charset=utf8 COMMENT '商品信息表';


-- 订单主表（order_master）
drop table if exists mall_system.order_master;
CREATE TABLE mall_system.order_master (
order_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
order_sn BIGINT UNSIGNED NOT NULL COMMENT '订单编号 yyyymmddnnnnnnnn',
customer_id INT UNSIGNED NOT NULL COMMENT '下单人ID',
shipping_user VARCHAR ( 10 ) NOT NULL COMMENT '收货人姓名',
province SMALLINT NOT NULL COMMENT '省',
city SMALLINT NOT NULL COMMENT '市',
district SMALLINT NOT NULL COMMENT '区',
address VARCHAR ( 100 ) NOT NULL COMMENT '地址',
payment_method TINYINT NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
order_money DECIMAL ( 8, 2 ) NOT NULL COMMENT '订单金额',
district_money DECIMAL ( 8, 2 ) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
shipping_money DECIMAL ( 8, 2 ) NOT NULL DEFAULT 0.00 COMMENT '运费金额',
payment_money DECIMAL ( 8, 2 ) NOT NULL DEFAULT 0.00 COMMENT '支付金额',
shipping_comp_name VARCHAR ( 10 ) COMMENT '快递公司名称',
shipping_sn VARCHAR ( 50 ) COMMENT '快递单号',
create_time bigint(20) DEFAULT '0'  COMMENT '下单时间',
shipping_time bigint(20) DEFAULT '0'  COMMENT '发货时间',
pay_time bigint(20) DEFAULT '0'  COMMENT '支付时间',
receive_time bigint(20) DEFAULT '0'  COMMENT '收货时间',
order_status TINYINT NOT NULL DEFAULT 0 COMMENT '订单状态',
order_point INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单积分',
invoice_time VARCHAR ( 100 ) COMMENT '发票抬头',
modified_time bigint(20) DEFAULT '0'  COMMENT '最后修改时间',
PRIMARY KEY pk_orderid ( order_id ) 
) engine=InnoDB default charset=utf8 COMMENT '订单主表';


-- 订单详情表（order_detail）
drop table if exists mall_system.order_detail;
CREATE TABLE mall_system.order_detail (
order_detail_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单详情表ID',
order_id INT UNSIGNED NOT NULL COMMENT '订单表ID',
product_id INT UNSIGNED NOT NULL COMMENT '订单商品ID',
product_name VARCHAR ( 50 ) NOT NULL COMMENT '商品名称',
product_cnt INT NOT NULL DEFAULT 1 COMMENT '购买商品数量',
product_price DECIMAL ( 8, 2 ) NOT NULL COMMENT '购买商品单价',
average_cost DECIMAL ( 8, 2 ) NOT NULL COMMENT '平均成本价格',
weight FLOAT COMMENT '商品重量',
fee_money DECIMAL ( 8, 2 ) NOT NULL DEFAULT 0.00 COMMENT '优惠分摊金额',
w_id INT UNSIGNED NOT NULL COMMENT '仓库ID',
modified_time bigint(20) DEFAULT '0' COMMENT '最后修改时间',
PRIMARY KEY pk_orderdetailid ( order_detail_id ) 
) engine=InnoDB default charset=utf8 COMMENT '订单详情表';

-- 购物车表（order_cart）
drop table if exists mall_system.order_cart;
CREATE TABLE mall_system.order_cart (
cart_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
customer_id INT UNSIGNED NOT NULL COMMENT '用户ID',
product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
product_amount INT NOT NULL COMMENT '加入购物车商品数量',
price DECIMAL ( 8, 2 ) NOT NULL COMMENT '商品价格',
add_time bigint(20) DEFAULT '0' COMMENT '加入购物车时间',
modified_time bigint(20) DEFAULT '0' COMMENT '最后修改时间',
PRIMARY KEY pk_cartid ( cart_id ) 
) engine=InnoDB default charset=utf8 COMMENT '购物车表';



-- 商品库存表（warehouse_product）
drop table if exists mall_system.warehouse_product;
CREATE TABLE mall_system.warehouse_product (
wp_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
current_cnt INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前商品数量',
lock_cnt INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前占用数据',
in_transit_cnt INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '在途数据',
average_cost DECIMAL ( 8, 2 ) NOT NULL DEFAULT 0.00 COMMENT '移动加权成本',
modified_time bigint(20) DEFAULT '0' COMMENT '最后修改时间',
PRIMARY KEY pk_wpid ( wp_id ) 
) engine=InnoDB default charset=utf8 COMMENT '商品库存表';



