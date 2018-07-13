### 项目基本架构

share
    
    share-common --> 通用工具包
    
    share-detail
       share-client-api     -->     app端网关接口应用
       share-dao            -->     数据持久化
       share-domain         -->     实体对象，请求对象，响应对象
       share-facade         -->     服务接口层
       share-facedeimpl     -->     服务接口实现层
       share-integration    -->     统一集成内部和外部服务层
       share-web-api        -->     web端网关接口应用