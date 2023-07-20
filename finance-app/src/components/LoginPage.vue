<template>
  <div>
    <div>
      <h2>Personal Finance System</h2>
      <form @submit.prevent="login">
        <div>
          <!--      <label for="username">Username:</label>-->
          <el-input type="text" id="username" v-model="username" placeholder="Username" required></el-input>
        </div>
        <div>
          <!--      <label for="password">Password:</label>-->
          <el-input type="password" id="password" placeholder="Password" v-model="pwd" required></el-input>
        </div>
        <el-button native-type="submit" size="small" type="primary">Login</el-button>
        <el-button id="regsiter" native-type="button" size="small" type="primary" @click="registerButton" >Register</el-button>
        <!--    <button type="submit">Login</button>-->
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'LoginPage',
  data () {
    return {
      username: '',
      pwd: ''
    }
  },
  methods: {
    login () {
      axios.post('/tUser/login', {
        username: this.username,
        pwd: this.pwd
      }, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      })
        .then(response => {
          // 处理登录成功的逻辑
          console.log(response.data)
          // console.log(response.data.data.uid)
          if (response.data.code === 200) {
            this.$router.push({
              path: 'FirstPage',
              query: { uid: response.data.data.uid }
            })
          } else {
            // 登陆失败则跳转到登录失败页面
            this.$router.push('/LoginFailed')
          }
        })
        // .catch(error => {
        //   // 处理登录失败的逻辑
        //   console.error(error)
        //   // this.$router.push('/LoginFailed')
        // })
    },
    registerButton () {
      this.$router.push('/RegisterPage')
    }
  }
}
</script>

<style scoped>
div{
  margin: 5px
}
#regsiter{

}
</style>
