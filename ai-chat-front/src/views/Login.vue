<template>

    <div class="container">
        <div class="container-left">
            <img src="@/assets/login-bg.svg" class="login-bg-img" alt="" />
            <img src="@/assets/login-box-bg.svg" class="login-box-bg-img" alt="" />
        </div>

        <div class="container-right">
            <div class="login-form">
                <div class="login-title">欢迎登录！</div>

                <el-tabs model-value="account" class="login-tabs" stretch @tab-click="changeLoginType">
                    <el-tab-pane label="账号密码登录" name="account">
                        <el-form :model="state.formData" :rules="state.accountRules" inline-message  ref="accoutnLoginForm">
                            <el-form-item style="width:100%" prop="account">
                                <el-input v-model="state.formData.account" placeholder="账号" size="large" />
                            </el-form-item>
                            <el-form-item style="width:100%" prop="password">
                                <el-input type="password" v-model="state.formData.password" placeholder="密码" size="large" />
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                    <el-tab-pane label="手机号码登录" name="telephone" >
                        <el-form :model="state.formData" :rules="state.verificationCodeRules" inline-message  ref="verificationCodeLoginForm">
                            <el-form-item style="width:100%" prop="telephone">
                                <el-input v-model="state.formData.telephone" placeholder="手机号码" size="large" />
                            </el-form-item>
                            <el-form-item style="width:100%" prop="verificationCode">
                                <el-input v-model="state.formData.verificationCode" placeholder="验证码" size="large" />
                            </el-form-item>
                        </el-form>
                    </el-tab-pane>
                </el-tabs>

                <el-row justify="space-between" style="width: 100%">
                    <el-col :span="6">
                        <el-checkbox :model="state.rememberMe">
                            记住我
                        </el-checkbox>
                    </el-col>
                    <el-col :offset="6" :span="12">
                        <el-link style="float: right" type="primary">
                            忘记密码?
                        </el-link>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="24">
                        <el-button type="primary" style="width: 100%; margin-top: 20px;" size="large" @click="submitForm">登录</el-button>
                    </el-col>
                </el-row>
            </div>   
        </div>

    </div>      
        
</template>

<script setup>
    import {reactive, ref} from 'vue'
    import axios from '@/utils/axios'
    // 安装 js-md5，密码需要 md5 加密，服务端是解密 md5 的形式
    import md5 from 'js-md5'
    import { localSet } from '@/utils'

    // el-form 组件接收一个 ref 属性，Vue3 需要这样声明
    const accoutnLoginForm = ref(null)
    const verificationCodeLoginForm = ref(null)


    const state = reactive({
        formData: {
            account: '',
            password: '',
            telephone: '',
            verificationCode: '',
            loginType: '1'
        },
        rememberMe: true,
        // 表单验证判断。
        accountRules: {
            account: [
                { required: 'true', message: '账号不能为空', trigger: 'blur' }
            ],
            password: [
                { required: 'true', message: '密码不能为空', trigger: 'blur' }
            ]
        },
        verificationCodeRules: {
            telephone: [
                { required: 'true', message: '手机号码不能为空', trigger: 'blur' }
            ],
            verificationCode: [
                { required: 'true', message: '验证码不能为空', trigger: 'blur' }
            ]
        }
    })

    const changeLoginType = (tab, event) => {
        console.log(tab.index)
        if(tab.index == 0){
            state.formData.loginType = '1'
        }else {
            state.formData.loginType = '2'
        }
        
    }

    const submitForm = async () => {
        console.log(process.env)
        let loginForm, formData
        if(state.formData.loginType === '1'){
            loginForm = accoutnLoginForm
            formData = {
                account: state.formData.account || '',
                password: md5(state.formData.password),
                loginType: state.formData.loginType || ''
            }
        }else{
            loginForm = verificationCodeLoginForm
            formData = {
                telephone: state.formData.telephone || '',
                verificationCode: state.formData.verificationCode || '',
                loginType: state.formData.loginType || ''
            }
        }
        loginForm.value.validate(valid => {
            if(valid){
                axios.post('/management/platform/user/login/doLogin', formData).then(res => {
                    // 返回的时候会有一个 token，这个令牌就是我们后续去请求别的接口时要带上的，否则会报错，非管理员。
                    // 这里我们将其存储到 localStorage 里面。
                    localSet('token', res)
                    // 此处登录完成之后，需要刷新页面
                    window.location.href = '/'
                })
            }
        })
    }

</script>

<style scoped>
.container {
    display: flex; 
    width: 100%;
    height: 100%;
}
.container-left {
    position: relative;
    display: inline-block;
    width: 55%;
    height: 100%;
}

.container-right {
    display: flex;
    width: 45%;
    height: 100%;
}
.login-bg-img {
    position: absolute;  
    top: 0;  
    left: 0;  
    width: 100%;
    height: 100%;
}
.login-box-bg-img {
    position: absolute;  
    top: 50%; /* 从容器顶部开始，向下移动50% */  
    left: 50%; /* 从容器左侧开始，向右移动50% */  
    transform: translate(-50%, -50%); /* 然后向上向左移动自身的50%，以实现居中 */ 
    width: 400px;
    height: 400px; 
}

.login-form {
    margin: auto;
    width: 360px;
    height: 350px;
}
.login-title {
    color: #1a1c1f;
    font-size: 24px;
    font-weight: 600;
    letter-spacing: 0;
    line-height: 36px;
    margin-bottom: 14px;
    text-align: left;
    width: 380px;
}
.el-form-item{
    margin: 20px 0 0 0;
}

</style>
