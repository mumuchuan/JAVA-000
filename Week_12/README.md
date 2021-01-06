学习笔记:

redis配置实操：
  redis下载地址：https://github.com/MicrosoftArchive/redis/releases
  1、本地解压
  2、进入解压目录，重命名redis.windows.conf配置文件->redis.windows.6379.conf，修改配置文件dir属性，修改后：dir ./dbcache_6379
  3、复制redis.windows.6379.conf文件两份，分别为：redis.windows.6380.conf、redis.windows.6381.conf，
     修改配置文件中相应的port属性->修改后：【redis.windows.6380.conf】port 6380、【redis.windows.6381.conf】port 6381，
	 修改配置文件中相应的dir属性->修改后：【redis.windows.6380.conf】dir ./dbcache_6380、【redis.windows.6381.conf】dir ./dbcache_6381
     在解压目录下分别创建文件夹 dbcache_6379、dbcache_6380、dbcache_6381
  4、启动服务：
     进入解压目录：分别打开三个命令行页面【cmd】、分别输入 -> redis-server.exe redis.windows.6379.conf、 
	                                                          redis-server.exe redis.windows.6380.conf、
						                                      redis-server.exe redis.windows.6381.conf
  5、连接：
     进入解压目录：分别打开三个命令行页面【cmd】、分别输入 -> redis-cli.exe -h 127.0.0.1 -p 6379
	                                                          redis-cli.exe -h 127.0.0.1 -p 6380
						                                      redis-cli.exe -h 127.0.0.1 -p 6381
  6、设置6379和6380的主从：
     在6380的连接窗口，输入： slaveof 127.0.0.1 6379 【设置为6379的从节点】
  7、设置哨兵：
     创建sentinel26379.conf文件，然后复制一份sentinel26380.conf
	 【sentinel26379.conf内容】
	 port 26379
	 sentinel myid fad25e089080be8dddadd3f20e44f888b1f8d48a
	 sentinel deny-scripts-reconfig yes
	 sentinel monitor mymaster 127.0.0.1 6379 2
	 sentinel down-after-milliseconds mymaster 10000
	 sentinel failover-timeout mymaster 15000
	 【sentinel26380.conf内容】
	 port 26380
	 sentinel myid fad25e089080be8dddadd3f20e44f888b1f8d48b
	 sentinel deny-scripts-reconfig yes
	 sentinel monitor mymaster 127.0.0.1 6379 2
	 sentinel down-after-milliseconds mymaster 10000
	 sentinel failover-timeout mymaster 15000
  8、启动哨兵:
       redis-server.exe sentinel26379.conf --sentinel
	   redis-server.exe sentinel26380.conf --sentinel
  9、Redis集群：
     （1）安装ruby环境：http://dl.bintray.com/oneclick/rubyinstaller/rubyinstaller-2.2.4-x64.exe
     （2）安装Ruby环境下Redis的驱动：https://rubygems.org/gems/redis/versions/3.2.2
     （3）将下载的“创建Redis集群的ruby脚本文件redis-trib.rb”文件拷贝到Redis安装根目录下：https://github.com/beebol/redis-trib.rb 
	 （4）新建配置文件redis.windows-service-6379.conf，内容如下：  
		port 6379     
		loglevel notice    
		logfile "D:/Software/work/install/Redis-x64-3.2.100/redis6379_log.txt"       
		appendonly yes
		appendfilename "appendonly.6379.aof"   
		cluster-enabled yes                                    
		cluster-config-file nodes.6379.conf
		cluster-node-timeout 15000
		cluster-slave-validity-factor 10
		cluster-migration-barrier 1
		cluster-require-full-coverage yes
		
		拷贝以上文件redis.windows-service-6381.conf，更改相关配置：6379->6381
	 （5）启动上面redis服务：
	     redis-server.exe redis.windows-service-6379.conf
         redis-server.exe redis.windows-service-6381.conf
	 （6）执行创建集群命令
	     redis-trib.rb create --replicas 1 127.0.0.1:6379 127.0.0.1:6381
	 （7）查看集群
         redis-trib.rb check 127.0.0.1:6380	 
