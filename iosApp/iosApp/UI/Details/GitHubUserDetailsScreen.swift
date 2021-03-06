//
//  GitHubUserDetailsScreen.swift
//  iosApp
//
//  Created by Imre Kaszab on 2022. 04. 10..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct GitHubUserDetailsScreen: View {
    @ObservedObject private var viewModel = GitHubUserDetailsViewModel()
    var userName: String

    var body: some View {
        ScrollView {
            if let userDetails = viewModel.userDetails {
                VStack {
                    if userDetails.name != userName {
                        Text(userDetails.name)
                            .font(.title)
                            .foregroundColor(.primary)
                    }
                    AsyncImage(url: URL(string: userDetails.avatarUrl)!) { image in
                        image.resizable().scaledToFill()
                    } placeholder: { Color.gray
                    }
                    .frame(width: 100, height: 100)
                    .cornerRadius(16)
                    GitHubUserDetailBioView(bio: userDetails.bio)
                    VStack {
                        GitHubUserDetailItemView(label: "Followers", value: String(userDetails.followers))
                        GitHubUserDetailItemView(label: "Following", value: String(userDetails.following))
                        GitHubUserDetailItemView(label: "Public repos", value: String(userDetails.publicRepos))
                        GitHubUserDetailItemView(label: "Company", value: userDetails.company)
                        GitHubUserDetailItemView(label: "Location", value: userDetails.location)
                        GitHubUserDetailItemView(label: "Email", value: userDetails.email)
                        GitHubUserDetailItemView(label: "Blog", value: userDetails.blog)
                        GitHubUserDetailItemView(label: "Twitter", value: userDetails.twitterUsername)
                    }
                }
            }
        }
        .navigationBarTitle(Text(userName))
        .onAppear {
            refreshUserDetails()
        }
    }

    func refreshUserDetails() {
        Task {
            await viewModel.refreshUserDetails(with: userName)
        }
    }
}
