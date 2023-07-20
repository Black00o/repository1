<template>
  <el-container direction="vertical">
    <el-main>
      <el-input v-model="input" placeholder="请输入账单号"></el-input>
      <el-button @click="DeleteData" type="primary">删除</el-button>
    </el-main>
  </el-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'DeletePage',
  data () {
    return {
      input: ''
    }
  },
  methods: {
    DeleteData () {
      // const tid = 123 // 根据实际情况设置要删除的数据的ID
      // const url = `/shanchu/${tid}` // 你的API端点URL
      axios.delete(`/tCharge/shanchu/${this.input}`)
        .then(response => {
          // 成功处理响应数据
          console.log(response.data)
          this.$message({
            message: '数据删除成功',
            type: 'success'
          })
        })
        .catch(error => {
          // 处理错误
          console.error(error)
          this.$message.error('删除失败')
        })
    }
  }
}
</script>

<style scoped>

</style>
