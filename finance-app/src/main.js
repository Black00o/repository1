import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import { Button, Input, Form, Container, Aside, Menu, Submenu, MenuItem, MenuItemGroup, Message, Table, TableColumn, Main, FormItem } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Button)
Vue.use(Input)
Vue.use(Form)
Vue.use(Container)
Vue.use(Aside)
Vue.use(Menu)
Vue.use(Submenu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Main)
Vue.use(FormItem)

Vue.prototype.$message = Message
Vue.config.productionTip = false
axios.defaults.baseURL = 'http://localhost:8080'

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
