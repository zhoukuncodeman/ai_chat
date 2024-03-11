import { createRouter, createWebHashHistory } from 'vue-router'
import Index from '@/views/Index'
import Login from '@/views/Login'

const router = createRouter({
    history: createWebHashHistory(), // hash 模式
    routes: [
      {
        path: '/',
        name: 'index',
        component: Index
      },
      {
        path: '/login',
        name: 'login',
        component: Login
      }
    ]
  })
  
export default router