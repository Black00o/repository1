const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8080,
    proxy: {
      '/tUser': {
        target: 'http://localhost:8080', // 后端接口的地址
        changeOrigin: true,
      },
      '/tCharge': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
      '/tBudget':{
        target: 'http://localhost:8080',
        changeOrigin:true,
      }
    },
  },
})
// module.exports = {
//   devServer: {
//     proxy: {
//       '/tUser': {
//         target: 'http://localhost:8080', // 后端接口的地址
//         changeOrigin: true,
//       },
//     },
//   },
// };
