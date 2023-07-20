# 个人理财系统
本项目旨在开发一个个人理财管理系统，帮助用户有效地管理个人财务、记账和预算，其中包括用户注册、用户登录、修改密码、记账管理和预算管理各自的CRUD功能。
- 项目结构：前端使用Vue2框架，后端使用Java SpringBoot，数据库使用MySQL版本为8.0.26。
- Vue中使用的技术栈包括Vue Router管理路由，Axios库负责前后端数据交互，Element UI。
# 安装
在开始之前，请确保您已经安装了以下环境：
- Node.js
- npm 或 yarn
您需要在本地安装Node.js和npm。
然后按照以下步骤进行安装：
```bash
git clone https://github.com/yourusername/personal-finance.git
cd personal-finance
npm install
```
# 使用
首先您需要将sql目录中的文件导入数据库。
本项目采用proxy代理时已经将后端端口默认为8080，需要先启动后端服务，再启动前端。
- 1.在pom.xml文件中maven会安装项目的依赖,在依赖安装完成后，运行
- 2.在idea的命令行中进入项目根目录，并运行以下命令来安装项目依赖：

```bash
cd finance-app
npm install
npm run serve
```
