import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginPage from '../components/LoginPage'
import FirstPage from '@/components/FirstPage'
import LoginFailed from '@/components/LoginFailed'
import RegisterPage from '@/components/RegisterPage'
import ChaxunCharge from '@/components/ChargeManager/ChaxunCharge'
import TestPage from '@/components/ChargeManager/TestPage'
import DeletePage from '@/components/ChargeManager/DeletePage'
import AddPage from '@/components/ChargeManager/AddPage'
import BudgetAddPage from '@/components/BudgetManager/AddPage'
import BudgetDeletePage from '@/components/BudgetManager/DeletePage'
import BudgetTestPage from '@/components/BudgetManager/BudgetTestPage'
import ChaxunBudget from '@/components/BudgetManager/ChaxunBudget'
import UpdatePwd from '@/components/UpdatePwd'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'login',
    component: LoginPage
  },
  {
    path: '/FirstPage',
    name: 'FirstPage',
    component: FirstPage,
    children: [
      {
        path: '/ChaxunCharge',
        name: 'ChaxunCharge',
        component: ChaxunCharge
      },
      {
        path: '/TestPage',
        name: 'TestPage',
        component: TestPage
      },
      {
        path: '/DeletePage',
        name: 'DeletePage',
        component: DeletePage
      },
      {
        path: '/AddPage',
        name: 'AddPage',
        component: AddPage
      },
      {
        path: '/BudgetAddPage',
        name: 'BudgetAddPage',
        component: BudgetAddPage
      },
      {
        path: '/BudgetDeletePage',
        name: 'BudgetDeletePage',
        component: BudgetDeletePage
      },
      {
        path: '/BudgetTestPage',
        name: 'BudgetTestpage',
        component: BudgetTestPage
      },
      {
        path: '/ChaxunBudget',
        name: 'ChaxunBudget',
        component: ChaxunBudget
      },
      {
        path: '/UpdatePwd',
        name: 'UpdatePwd',
        component: UpdatePwd
      }
    ]
  },
  {
    path: '/LoginFailed',
    name: 'LoginFailed',
    component: LoginFailed
  },
  {
    path: '/RegisterPage',
    name: 'RegisterPage',
    component: RegisterPage
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
