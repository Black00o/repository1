<template>
<div>
  <h2>登录失败,请点击返回，并尝试重新登录</h2>
  <el-button native-type="button" size="small" type="primary" @click="BackToLogin">返回</el-button>
</div>
</template>

<script>
export default {
  name: 'LoginFailed',
  methods: {
    BackToLogin () {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>
