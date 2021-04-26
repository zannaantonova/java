<template>
  <div class="home">
    <input placeholder="enter your email" v-model="email">
    <button v-on:click="register()">Register</button>
    <table>
      <tr>
        <th>Emailid</th>
      </tr>
      <tr v-for="e in emails">
        {{e}}
      </tr>
    </table>
    <input v-model.number="a"> <input v-model.number="b"> {{a + b}}
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

function register() {
  alert(this.email);
  this.emails.push(this.email);
}

export default {
  name: 'Home',
  components: {
    HelloWorld
  }, methods: {
    register: register
  }, data: function (){
    return {
      email: "",
      emails: ["a@a.ee", "b@b.com"],
      a: 0,
      b: 0
    }
  }
}
</script>
