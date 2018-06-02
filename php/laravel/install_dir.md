## 下载和安装

####通过 Laravel 安装工具

首先，使用 Composer 下载 Laravel 安装包：

```
composer global require "laravel/installer"
```
请确定你已将 `~/.composer/vendor/bin` 路径加到 PATH，只有这样系统才能找到 laravel 的执行文件。

一旦安装完成，就可以使用 `laravel new` 命令在指定目录创建一个新的 Laravel 项目。
例如：`laravel new blog` 将会在当前目录下创建一个叫 blog 的目录，此目录里面存放着新安装的 Laravel 和代码依赖。
这个方法的安装速度比通过 Composer 安装要快上许多，因为代码依赖是直接一起打包安装的。

```
laravel new blog
```

在安装 Laravel 之后，你需要配置你的 Web 服务器的根目录为 public 目录。 这个目录的 index.php 文件作为所有 HTTP 请求进入应用的前端处理器。
> 目录权限   
安装 Laravel 之后， 你需要配置一些权限 。 storage 和 bootstrap/cache 目录应该允许你的 Web 服务器写入，否则 Laravel 将无法写入。


## 目录结构解析

```
Laravel
├─app                       --- 应用程序的核心代码
│  ├─Console                --- 应用所有自定义的 Artisan 命令
│  ├─Exceptions 
│  ├─Http                   --- 目录包含了控制器、中间件以及表单请求等，几乎所有进入应用的请求处理都在这里进行。
│  │  ├─Controllers
│  │  └─Middleware         
│  └─Providers
├─bootstrap                 --- 几个框架启动和自动加载设置的文件
├─config					--- 应用程序的配置文件
├─database                  --- 数据迁移及填充文件，你还可以将其作为 SQLite 数据库的存放目录。
│  ├─migrations             --- 
├─public                    --- Laravel 的 HTTP 入口文件 index.php 和前端资源文件（图片、JavaScript、CSS等）。
├─resources                 --- 视图、原始的资源文件 (LESS、SASS、CoffeeScript) ，以及语言包。
│  ├─assets
│  ├─lang
│  └─views
├─routes                    --- 应用的所有路由定义。Laravel 默认提供了三个路由文件：web.php, api.php, 和 console.php。
├─storage                   --- 编译后的 Blade 模板、基于文件的 session、文件缓存和其它框架生成的文件。
│  ├─app
│  ├─framework
│  └─logs
├─tests                     --- 目录包含自动化测试。
│  ├─Feature
│  └─Unit
└─vendor                    --- 包含所有 Composer 依赖。

```

>Laravel 默认的目录结构意在为构建不同大小的应用提供一个好的起点，当然，你可以自己按照喜好组织应用目录结构，Laravel 对类在何处被加载没有任何限制 -- 只要 Composer 可以自动载入它们即可。

#### 为什么没有 Models 目录?#

许多初学者都会困惑 Laravel 为什么没有 models 目录,当然，这是 laravel 故意为之，因为 models 这个词对不同开发者而言有不同的含义，容易造成歧义，有些开发者认为应用的模型指的是业务逻辑，还有些开发者则认为模型指的是与关联数据库的交互。

正是因为如此，我们默认将 Eloquent 的模型放置到 app 目录下，从而允许开发者自行选择放置的位置。


## 根目录#

### app 目录#

app 目录，如你所料，这里面包含应用程序的核心代码。另外，你为应用编写的代码绝大多数也会放到这里， 我们之后将很快对这个目录的细节进行深入探讨。


### bootstrap 目录#

bootstrap目录包含了几个框架启动和自动加载设置的文件。cache 文件夹用于包含框架为提升性能所生成的文件，如路由和服务缓存文件。


### config 目录#

config 目录，顾名思义，包含所有应用程序的配置文件。通读这些配置文件可以应对自己对配置修改的需求。


### database 目录#

database 目录包含了数据迁移及填充文件，你还可以将其作为 SQLite 数据库的存放目录。


### public 目录#

public 目录包含了 Laravel 的 HTTP 入口文件 index.php 和前端资源文件（图片、JavaScript、CSS等）。


### resources 目录#

resources 目录包含了视图、原始的资源文件 (LESS、SASS、CoffeeScript) ，以及语言包。


### routes 目录#

routes 目录包含了应用的所有路由定义。Laravel 默认提供了三个路由文件：web.php, api.php, 和 console.php。

web.php 文件里定义的路由都会在 RouteServiceProvider 中被指定应用到 web 中间件组，具备 Session 、CSRF 防护以及 Cookie 加密功能，如果应用无需提供无状态的、RESTful 风格的API，所有路由都会定义在 web.php 文件。

api.php 文件里定义的路由都会在 RouteServiceProvider 中被指定应用到 api 中间件组，具备频率限制功能，这些路由是无状态的，所以请求通过这些路由进入应用需要通过 API 令牌进行认证并且不能访问 Session 状态。

console.php 文件用于定义所有基于闭包的控制台命令，每个闭包都被绑定到一个控制台命令并且允许与命令行 IO 方法进行交互，尽管这个文件并不定义 HTTP 路由，但是它定义了基于命令行的应用入口（路由）。


### storage 目录#

storage 目录包含编译后的 Blade 模板、基于文件的 session、文件缓存和其它框架生成的文件。此文件夹分格成 app 、framework ，及 logs 目录。app 目录可用于存储应用程序使用的任何文件。framework 目录被用于保存框架生成的文件及缓存。最后，logs 目录包含了应用程序的日志文件。

storage/app/public 可以用来存储用户生成的文件，例如头像文件，这是一个公开的目录。你还需要在 public/storage 目录下生成一个软连接指向这个目录，你可以使用 php artisan storage:link 来创建软链接。


### tests 目录#

tests 目录包含自动化测试。Laravel 推荐了一个 PHPUnit 例子。每一个测试类都需要添加 Test 前缀，你可以使用 `phpunit` 或者 `php vendor/bin/phpunit` 命令来运行测试。


### vendor 目录#

vendor 目录包含所有 Composer 依赖。

--- 

## app 目录#
应用的核心代码位于 app 目录下，默认情况下，该目录位于命名空间 App 下， 并且被 Composer 通过 PSR-4 自动载入标准 自动加载。

app 目录下包含多个子目录，如 Console 、Http 、Providers 等。 其中 Console 和 Http 目录为进入应用程序核心提供了一个 API 。HTTP 协议和 CLI 是和应用进行交互的两种机制，但实际上并不包含应用逻辑。换句话说，它们是两种简单地发布命令给应用程序的方法。Console 目录包含你全部的 Artisan 命令，而 Http 目录包含你的控制器、中间件和请求。

其他目录将会在你通过 Artisan 命令 `make` 生成相应类的时候生成到 app 目录下。例如，app/Jobs 目录在你执行 `make:job` 命令生成任务类时，才会出现在 app 目录下。

app 目录中的很多类都可以通过 Artisan 命令生成，要查看所有有效的命令，可以在终端中运行 `php artisan list make` 命令。


### Console 目录#

Console 目录包含应用所有自定义的 Artisan 命令，这些命令类可以使用 `make:command` 命令生成。该目录下还有 Console Kernel 类，在这里可以注册自定义的 Artisan 命令以及定义调度任务。


### Events 目录#

Events 目录默认不存在，它会在你使用 `event:generate` 或者 `event:make` 命令以后才会生成。如你所料，此目录是用来放置 事件类 的。事件类用于当指定事件发生时，通知应用程序的其它部分，并提供了很棒的灵活性及解耦。


### Exceptions 目录#

Exceptions 目录包含应用的异常处理，同时还是处理应用抛出的任何异常的好位置。如果你想自定义异常的记录和渲染，你应该修改此目录下的 Handler 类。


### Http 目录#

Http 目录包含了控制器、中间件以及表单请求等，几乎所有进入应用的请求处理都在这里进行。


### Jobs 目录#

Jobs 目录默认不存在，可以通过执行 `make:job` 命令生成，Jobs 目录用于存放 队列任务，应用中的任务可以推送到队列，也可以在当前请求生命周期内同步执行。同步执行的任务有时也被看作命令，因为它们实现了 命令总线设计模式。


### Listeners 目录#

Listeners 目录默认不存在，可以通过执行 `event:generate` 和 `make:listener` 命令创建。Listeners 目录包含处理 事件 的类（事件监听器），事件监听器接收一个事件并提供对该 事件发生后的响应逻辑，例如，UserRegistered 事件可以被 SendWelcomeEmail 监听器处理。


### Mail 目录#

Mail 目录默认不存在，但是可以通过执行 `make:mail` 命令生成，Mail 目录包含邮件发送类，邮件对象允许你在一个地方封装构建邮件所需的所有业务逻辑，然后使用 Mail::send 方法发送邮件。


### Notifications 目录#

Notifications 目录默认不存在，你可以通过执行 `make:notification` 命令创建， Notifications 目录包含应用发送的所有通知，比如事件发生通知。Laravel 的通知功能将通知发送和通知驱动解耦，你可以通过邮件，也可以通过 Slack、短信或者数据库发送通知。


### Policies 目录#

Policies 你可以通过执行 `make:policy` 命令来创建， Policies  目录包含了所有的授权策略类，策略用于判断某个用户是否有权限去访问指定资源。更多详情，请查看 授权文档。


### Providers 目录#

Providers 目录包含应用的 服务提供者 。服务提供者在启动应用过程中绑定服务到容器、注册事件，以及执行其他任务，为即将到来的请求处理做准备。

在新安装的 Laravel 应用中，该目录已经包含了一些服务提供者，你可以按需添加自己的服务提供者到该目录。

 