
# springcloud-projects-Greenwich.RELEASE
基于spring cloud Greenwich.RELEASE版本的微服务，其中使用spring boot 2.1.3.RELEASE，搭建了基于spring cloud的微服务，目前项目有：公用spring cloud pom工程(ms-parent)、eureka服务注册中心(ms-eureka-server)、配置中心(ms-config-server)、服务服监控(ms-admin-server)、服务网关-spring cloud gateway版(ms-gateway)、服务网关-zuul版(ms-zuul-gateway)、服务链路跟踪(ms-zipkin-server，注：spring boot2.0后官方已经打包好了，不建议再自己集成打包，这里自己集成了一个玩玩，实际项目中还是使用官方打好的jar包)、产品服务(product-server，即：服务提供者)，产品服务调用(proejct1,这里放到了另一个目录下(https://github.com/ltlwill/spring-cloud-Finchley.SR1.git/project1)，为了演示不在同一个电脑、工作空间等环境下怎样使用同一个ms-parent父项目,这里是将ms-parent父项目的pom文件上传到私有maven仓库),当然还有其他的，如：数据库、消息中间件(rabbitmq)、SVN、GIT等

# spring-cloud-projects-Greenwich.RELEASE
Spring Cloud Greenwich.RELEASE 版本微服务项目

注：需要安装rabbitmq、mysql数据库等才能完整运行起来
