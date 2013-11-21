class NotificationsController < ApplicationController

  def index
    @school = School.find(params[:school_id])
  end

  def show
    @notification = Notification.find(params[:id])
  end

  def new
  end

end
