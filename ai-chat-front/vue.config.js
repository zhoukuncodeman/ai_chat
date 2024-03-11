const { defineConfig } = require('@vue/cli-service')
const path = require('path')
const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const { ElementPlusResolver } = require('unplugin-vue-components/resolvers')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,
  configureWebpack: {
    resolve: {
      alias: {
        '@': path.resolve(__dirname, 'src')
      }
    },
    plugins: [
      AutoImport({
        resolvers: [ElementPlusResolver()],
      }),
      Components({
        resolvers: [ElementPlusResolver()],
      }),
    ],
  },
  devServer: {                //这里都是配置开发环境参数
    port: 8080,					//设置开发环境前端端口  选填
    proxy: {                 //设置开发环境代理
        '/api': {              //设置拦截器  拦截器格式   斜杠+拦截器名字，名字可以自己定
            target: 'http://localhost:8800/',     //代理的目标地址(后端设置的端口号)
            changeOrigin: true,              //是否设置同源，输入是的
            pathRewrite: { // 重定向
                '^/api': ''
            }
        }
    }
  }
})
