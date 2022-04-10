
var app5 = new Vue({
    el: '#app-5',
    data: {
        is2020: false,
        message: 'Hello Vue.js!',
        green: '#0aea15',
        red: '#ee0808',
        yellow: '#ec9508',
        isButtonDisabled: false
    },
    methods: {
        changeYear: function () {
            this.is2020 = !this.is2020
        }
    }
})

