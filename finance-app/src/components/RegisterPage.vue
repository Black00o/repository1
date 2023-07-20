<template>
<div>
  <h2>Register</h2>
  <form @submit.prevent="Register">
    <div>
      <!--      <label for="username">Username:</label>-->
      <el-input type="text" id="username" v-model="username" placeholder="Username" required></el-input>
    </div>
    <div>
      <!--      <label for="password">Password:</label>-->
      <el-input type="password" id="password" placeholder="Password" v-model="pwd" required></el-input>
    </div>
    <el-button native-type="submit" size="small" type="primary">register</el-button>
    <el-button id="regsiter" native-type="button" size="small" type="primary" @click="BackToLogin" >Back</el-button>
    <!--    <button type="submit">Login</button>-->
  </form>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'RegisterPage',
  data () {
    return {
      username: '',
      pwd: ''
    }
  },
  methods: {
    BackToLogin () {
      this.$router.push('/login')
    },
    Register () {
      axios.post('/tUser/register', {
        username: this.username,
        pwd: this.pwd
      }, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(response => {
          // 处理注册成功的逻辑
          console.log(response.data)
          if (response.data.code === 200) {
            // 添加提醒，“注册成功”
            this.$message('注册成功')
            this.$router.push('/login')
          } else {
            // 注册失败则跳转到注册失败页面
            this.$message('注册失败')
            this.$router.push('/LoginFailed')
          }
        })
    }
  }
}
</script>

<style scoped>

</style>
