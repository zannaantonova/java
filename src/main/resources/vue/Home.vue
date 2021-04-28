<template>
  <div class="home">
    <input v-model="accountNumber">
    <button v-on:click="showBalance()">Show balance</button>
    <br/>
    Account balance is: {{ showBalanceAnswer }}
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  methods: {
    showBalance: function () {
      this.$http.get("http://localhost:8080/sample/account/" + this.accountNumber)
          .then(response => {
            this.showBalanceAnswer = response.data;
          })
          .catch(response => {
            alert("juhtus viga")
          })
    }
  }, data: function () {
    return {
      accountNumber: "",
      showBalanceAnswer: ""
    }
  }
}
</script>
