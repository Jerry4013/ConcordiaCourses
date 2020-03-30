import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.scss']
})
export class SideNavComponent implements OnInit {

  constructor(private authService: AuthService) { }

  links: linkData[] = [
    {
      icon: "home",
      label: "Home",
      path: "/home"
    },
    {
      icon:"email",
      label: "Email",
      path:"/email"
    },
    {
      icon:"event",
      label: "Events",
      path:"/event"
    },
    {
      icon:"group_work",
      label: "Group",
      path:"/group"
    }
  ];

  ngOnInit() {
  }

  get isAdmin():boolean{
    return this.authService.isAdmin();
  }
}

interface linkData {
  icon:string;
  label:string;
  path:string;
}
