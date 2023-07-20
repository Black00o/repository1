<template>
  <el-container style="height: 600px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1']" :default-active="this.$route.path" router>
        <el-submenu index="1">
          <template slot="title">记账管理</template>
            <el-menu-item index="/AddPage">1.增加账单信息</el-menu-item>
            <el-menu-item index="/DeletePage">2.删除账单信息</el-menu-item>
            <el-menu-item index="/TestPage">3.修改账单信息</el-menu-item>
          <el-menu-item index="/ChaxunCharge">4.查找账单信息</el-menu-item>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">预算管理</template>
          <el-menu-item index="/BudgetAddPage">1.增加账单信息</el-menu-item>
          <el-menu-item index="/BudgetDeletePage">2.删除账单信息</el-menu-item>
          <el-menu-item index="/BudgetTestPage">3.修改账单信息</el-menu-item>
          <el-menu-item index="/ChaxunBudget">4.查找账单信息</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">个人中心</template>
          <el-menu-item index="/UpdatePwd">1.修改密码</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>
    <router-view></router-view>
  </el-container>
</template>

<script>
export default {
  name: 'FirstPage',
  mounted () {
    // const uid = this.$route.query.uid
    console.log('这是FirstPage中的uid' + this.$route.query.uid)
  }
}
</script>

<style scoped>

</style>
