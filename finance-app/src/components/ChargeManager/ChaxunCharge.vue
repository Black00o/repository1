<template>
  <el-container direction="vertical">
    <el-main>
      <el-input v-model="input" placeholder="请输入账单号"></el-input>
      <el-button @click="Chaxun" type="primary">查询</el-button>
      <el-table :data="tableData" style="height: 300px">
        <el-table-column prop="ttime" label="日期" width="140">
        </el-table-column>
        <el-table-column prop="typename" label="类型" width="120">
        </el-table-column>
        <el-table-column prop="account" label="金额数目">
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>
<script>
import axios from 'axios'
export default {
  name: 'AddCharge',
  data () {
    return {
      tableData: [],
      input: ''
    }
  },
  mounted () {
    // const uid = this.$route.query.uid
    console.log('这是ChaxunCharge中的uid' + this.$route.query.uid)
  },
  methods: {
    Chaxun () {
      axios.get(`/tCharge/chaxun/${this.input}`)
        .then(response => {
          // 请求成功的回调函数
          console.log(response.data)
          // console.log(response.data.typename)
          const item = {
            ttime: response.data.ttime,
            typename: response.data.typename,
            account: response.data.account
          }
          console.log(item)
          this.tableData = Array(1).fill(item)
        })
        .catch(error => {
          // 请求失败的回调函数
          console.error(error)
        })
    }
  }
}
</script>

<style scoped>

</style>
