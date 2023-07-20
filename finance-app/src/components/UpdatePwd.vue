<template>
  <div>
    <el-input v-model="username" placeholder="请输入用户名"></el-input>
    <el-input v-model="oldPwd" placeholder="请输入旧密码"></el-input>
    <el-input v-model="newPwd" placeholder="请输入新密码"></el-input>
    <el-button type="primary" @click="modifyPwd">修改密码</el-button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'UpdatePwd',
  data () {
    return {
      username: '',
      oldPwd: '',
      newPwd: ''
    }
  },
  methods: {
    modifyPwd () {
      // const url = '/modify/pwd' // 你的API端点URL

      const requestData = {
        username: this.username,
        oldPwd: this.oldPwd,
        newPwd: this.newPwd
      }
      axios.put('/tUser/modify/pwd', null, { params: requestData })
        .then(response => {
          // 成功处理响应数据
          console.log(response.data)
          if (response.data.code === 200) {
            this.$message({
              message: '密码修改成功',
              type: 'success'
            })
          } else {
            this.$message.error('密码修改失败,请重试')
          }
        })
        .catch(error => {
          // 处理错误
          console.error(error)
        })
    }
  }
}
</script>

<style scoped>

</style>
