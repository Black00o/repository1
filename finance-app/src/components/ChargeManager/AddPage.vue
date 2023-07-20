<template>
  <el-container direction="vertical">
    <el-main>
      <el-form :model="formData" @submit.native.prevent="AddData">
        <el-form-item label="账单号">
          <el-input v-model="formData.tid" placeholder="请输入账单号"></el-input>
        </el-form-item>
        <el-form-item label="日期">
          <el-input v-model="formData.ttime" placeholder="请输入日期"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-input v-model="formData.typename" placeholder="请输入类型"></el-input>
        </el-form-item>
        <el-form-item label="金额数目">
          <el-input v-model="formData.account" placeholder="请输入金额数目"></el-input>
        </el-form-item>
        <!-- 其他字段 -->

        <el-form-item>
          <el-button type="primary" native-type="submit">添加数据</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'AddPage',
  data () {
    return {
      formData: {
        tid: '',
        ttime: '',
        typename: '',
        account: ''
        // 其他字段
      }
    }
  },
  methods: {
    AddData () {
      axios.post('/tCharge/add', this.formData)
        .then(response => {
          // 成功处理响应数据
          this.$message({
            message: '数据添加成功',
            type: 'success'
          })
          console.log(response.data)
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
